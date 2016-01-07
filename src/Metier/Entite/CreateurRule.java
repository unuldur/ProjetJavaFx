package Metier.Entite;

import java.util.ArrayList;

/**
 * Created by PAYS on 07/01/2016.
 */
public class CreateurRule {

    ArrayList<RuleEntite> ruleEntites = new ArrayList<>();

    public RuleEntite createurRule(String classe)
    {
        try {

            RuleEntite rule = (RuleEntite) Class.forName(classe).newInstance();
            if(!ruleEntites.contains(rule))
            {
                ruleEntites.add(rule);
            }
            else
            {
                rule = ruleEntites.get(ruleEntites.indexOf(rule));
            }
            return rule;
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.toString());
            return null;
        }
        catch(InstantiationException e)
        {
            System.out.println(e.toString());
            return null;
        }
        catch (IllegalAccessException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }
}
