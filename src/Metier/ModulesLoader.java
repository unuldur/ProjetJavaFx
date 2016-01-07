package Metier;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
public class ModulesLoader {
    // Singleton
    private static ModulesLoader instance = new ModulesLoader();
    private List<String> modulesPackages = new ArrayList<String>();
    /**
     * <code>filter</code> accept directory and *.class (without $)
     */
    private static final FileFilter filter = new FileFilter() {
        public boolean accept(File pathname) {
            // Accept directory
            if (pathname.isDirectory())
                return true;
            // But nothing else that regular file
            if (!pathname.isFile())
                return false;
            // File must have ".class" extension
            String path = pathname.getAbsolutePath();
            if (!path.endsWith(".class" ))
                return false;
            // And not contain a "$", so plugin defined as inner class are not
            // permitted
            return path.indexOf('$') < 0;
        }
    };
    private ModulesLoader() {}

    public ModulesLoader getInstance() {
        return instance;
    }

    public static boolean addModulesPackage(String s) {
        return instance.modulesPackages.add(s);
    }
    /**
     * @see java.util.List#remove(java.lang.Object)
     */
    public static boolean removeModulesPackage(String s) {
        return instance.modulesPackages.remove(s);
    }
    /**
     * @return Returns the plugins list.
     */
    public static final Collection<Class> getPlugins(Class pluginSuperClass) throws IOException {
        assert pluginSuperClass != null;
        Collection<Class> plugins = new ArrayList<Class>();
        String pluginHomeResource,pluginFileName;
        for (String packageName : instance.modulesPackages) {
            pluginHomeResource = packageName.replace('.', '/');
            pluginFileName = packageName.replace('.', File.separatorChar);
            plugins.addAll(instance.analyze(pluginSuperClass,pluginHomeResource,pluginFileName));
        }
        return plugins;
    }
    /**
     * <code>analyze</code> Search modules available.
     * @throws IOException If I/O errors occur @see java.lang.ClassLoader#getResources(java.lang.String)
     */
    private Collection<Class> analyze(Class pluginSuperClass,String pluginHomeResource, String pluginFileName) throws IOException {
        Collection<Class> plugins = new ArrayList<Class>();
        // fetchs list of directories that provides ressources under package pluginHomeResource
        Enumeration e = this.getClass().getClassLoader().getResources(pluginHomeResource);
        // analyze each directory and jar archive in this list
        while (e.hasMoreElements()) {
            URL url = (URL) e.nextElement();
            String protocol = url.getProtocol();
            if (protocol.equals("file" ))
                plugins.addAll(analyzeFromDirectory(new File(url.getFile().replace("%20", " " )), pluginSuperClass, pluginFileName));
            else if (protocol.equals("jar" ))
                plugins.addAll(analyzeFromJar(url,pluginSuperClass,pluginHomeResource));
        }
        return plugins;
    }
    /**
     * <code>analyzeFromDirectory</code> Analyze a directory.
     *
     * @param directory is the base directory to analyze
     */
    private Collection<Class> analyzeFromDirectory(File directory, Class pluginSuperClass, String pluginFileName) {
        Collection<Class> plugins = new ArrayList<Class>();
        Class classBuff;
        boolean instanciable;
        if (!directory.isDirectory())
            return plugins;
        // for each element in current directory
        for (File file : directory.listFiles(ModulesLoader.filter)) {
            if (file.isDirectory()) {
                // analyze recursively sub-directory
                plugins.addAll(analyzeFromDirectory(file,pluginSuperClass,pluginFileName));
            } else {
                classBuff = null;
                // Convert file path to package path
                String name = file.getAbsolutePath();
                int pos = name.indexOf(pluginFileName);
                // Checks that file is in a subdirectory of base package => suposed true
                assert pos >= 0;
                name = name.replace(File.separatorChar, '.').substring(pos);
                classBuff = analyseClassFile(name,pluginSuperClass);
                if (classBuff!=null) {
                    plugins.add(analyseClassFile(name,pluginSuperClass));
                }
            }
        }
        return plugins;
    }
    /**
     * <code>analyzeFromJar</code> Analyze a JAR archive
     *
     * @param url The jar file to analyze
     */
    private Collection<Class> analyzeFromJar(URL url, Class pluginSuperClass,String pluginHomeResource) {
        Collection<Class> plugins = new ArrayList<Class>();
        String jarName = url.getFile();
        jarName = jarName.substring(jarName.indexOf(':'));
        jarName = jarName.substring(0, jarName.indexOf('!'));
        jarName = jarName.replace('/', File.separatorChar);
        try {
            ZipFile zipFile = new ZipFile(jarName);
            for (Enumeration<? extends ZipEntry> e = zipFile.entries();e.hasMoreElements();) {
                ZipEntry entry = e.nextElement();
                String name = entry.getName();
                if ((name.endsWith(".class" )) && (name.startsWith(pluginHomeResource)) && (name.indexOf('$') >= 0)) {
                    name = name.replace('/', '.');
                    plugins.add(analyseClassFile(name,pluginSuperClass));
                }
            }
            zipFile.close();
        } catch (IOException e) {
            assert false;
            e.printStackTrace();
        }
        return plugins;
    }

    private Class analyseClassFile(String name, Class pluginSuperClass) {
        Class result = null;
        // remove .class extension
        name = name.substring(0, name.length() - 6);
        // Convert file to Class
        try {
            Class plugin = Class.forName(name);
            // Checks if it's a sub-class of the plugins super-class
            if (pluginSuperClass.isAssignableFrom(plugin)) {
                // checks it isn't an abstract class
                if ((!plugin.isInterface())&&(!Modifier.isAbstract(plugin.getModifiers())))
                    // add to the list of plugins
                    result = plugin;
            }
        } catch (ClassNotFoundException e) {
            // if file to Class conversion fails
            System.err.println("file to Class conversion fails while dpugins loading" );
            e.printStackTrace();
        }
        catch (ExceptionInInitializerError e)
        {
            System.out.println(e.getMessage());
        }
        return result;
    }

}