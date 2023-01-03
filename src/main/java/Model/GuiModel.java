package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuiModel {

public Polynomials removeZero(Polynomials pol)
{
    List<Integer> keys = new ArrayList<>();
    for (Integer key: pol.getPolynomial().keySet()) {
        if(pol.getPolynomial().get(key) == 0)
        {
            keys.add(key);
        }
    }
    for (Integer key : keys) {
        pol.getPolynomial().remove(key);
    }

    return pol;
}

public Polynomials addPol(Polynomials pol1,Polynomials pol2)
{
    for (Integer key : pol2.getPolynomial().keySet()) {
        if(pol1.getPolynomial().containsKey(key))
        {
            pol1.getPolynomial().replace(key,pol1.getPolynomial().get(key) + pol2.getPolynomial().get(key));
        }
        else
        {
            pol1.getPolynomial().put(key,pol2.getPolynomial().get(key));
        }
    }
    removeZero(pol1);
    return pol1;
}
    public Polynomials subPol(Polynomials pol1,Polynomials pol2)
    {
        for (Integer key : pol2.getPolynomial().keySet()) {
            if(pol1.getPolynomial().containsKey(key))
            {
                pol1.getPolynomial().replace(key,pol1.getPolynomial().get(key) - pol2.getPolynomial().get(key));
            }
            else
            {
                pol1.getPolynomial().put(key,(-1) * pol2.getPolynomial().get(key));
            }
        }
        removeZero(pol1);
        return pol1;
    }

    public Polynomials multPol(Polynomials pol1,Polynomials pol2)
    {
        Polynomials multy = new Polynomials();
        for (Integer key : pol1.getPolynomial().keySet()) {
            for (Integer key2 : pol2.getPolynomial().keySet())
            {
                if(multy.getPolynomial().containsKey(key + key2))
                {
                    multy.getPolynomial().replace(key + key2, multy.getPolynomial().get(key * key2) + (pol1.getPolynomial().get(key) * pol2.getPolynomial().get(key2)));
                }
                else
                {
                    multy.getPolynomial().put(key + key2, pol1.getPolynomial().get(key) * pol2.getPolynomial().get(key2));
                }
            }
        }
        return multy;
    }
    public int findMax(Polynomials pol)
    {
        int pow = 0;
        for (Integer key: pol.getPolynomial().keySet()) {
            pow = key;
        }
        return pow;
    }

    public String divPol(Polynomials pol1,Polynomials pol2)
    {
        Polynomials cat = new Polynomials();
        int prinPow = findMax(pol2);
        Double prinCoef = pol2.getPolynomial().get(prinPow);
        if(prinPow == 0 && prinCoef == 0.0) {return "Invalid!";}
        int secPow = findMax(pol1);
        Double secCoef = pol1.getPolynomial().get(secPow);
        while(prinPow <= secPow) {
            Polynomials aux = new Polynomials();
            Polynomials aux2 = new Polynomials(pol2.getPolynomial());
            aux.getPolynomial().put(secPow - prinPow,secCoef/prinCoef);
            aux2 = multPol(aux2,aux);
            pol1 = subPol(pol1,aux2);
            removeZero(pol1);
            cat = addPol(cat,aux);
            secPow = findMax(pol1);
            secCoef = pol1.getPolynomial().get(secPow);
        }
        removeZero(pol1);
        return transformationReal(cat) + "          REST:" + transformationReal(pol1);
    }
    public Polynomials derivPol(Polynomials pol1)
    {
        Polynomials deriv = new Polynomials();
        for (Integer key : pol1.getPolynomial().keySet())
        {
            double result;
            if(key == 0)
            {
                result = 0;
            }
            else
            {   result = pol1.getPolynomial().get(key) * key;
                if(deriv.getPolynomial().containsKey(key - 1))
                {
                    deriv.getPolynomial().replace(key - 1, deriv.getPolynomial().get(key - 1) + result);
                }
                else
                {
                    deriv.getPolynomial().put(key - 1, result);
                }
            }

        }
        removeZero(deriv);
        return deriv;
    }
    public Polynomials integPol(Polynomials pol1)
    {
        Polynomials integ = new Polynomials();
        for (Integer key : pol1.getPolynomial().keySet())
        {
                Double result = pol1.getPolynomial().get(key) / (key + 1);
                if(integ.getPolynomial().containsKey(key + 1))
                {
                    integ.getPolynomial().replace(key + 1, integ.getPolynomial().get(key + 1) + result);
                }
                else
                {
                    integ.getPolynomial().put(key + 1, result);
                }
        }
        return integ;
    }
    public String stringNegTransformFor0(Polynomials pol, Integer key)
    {String result = "";
        DecimalFormat df = new DecimalFormat("0.00");
        if(key == 0){
            result = result + df.format(pol.getPolynomial().get(key));
        }
        else
            if(key == 1) {
                result = result + df.format(pol.getPolynomial().get(key)) +"X";
            }
        else
        {
            result = result + df.format(pol.getPolynomial().get(key)) +"X^"+ key;
        }
        return result;
    }
    public String stringPozTransformFor0(Polynomials pol, Integer key)
    {String result = "";
        DecimalFormat df = new DecimalFormat("0.00");
        if(key == 0){
            result = result + "+" + df.format(pol.getPolynomial().get(key));
        }
        else
            if(key == 1)
            {
                result = result + "+" + df.format(pol.getPolynomial().get(key)) +"X";
            }
        else{
            result = result + "+" + df.format(pol.getPolynomial().get(key)) +"X^"+ key;
        }
        return result;
    }

    public String transformationReal(Polynomials pol)
    {   String result = "";
        boolean see = true;
        for (Integer key: pol.getPolynomial().keySet()) {
            if(pol.getPolynomial().get(key) < 0)
            {
                result = stringNegTransformFor0(pol,key);
            }
            else{
                result = stringPozTransformFor0(pol,key);
            }
        }
        if(result.charAt(0) == '+') {
            result = result.substring(1,result.length());
        }
        return result;
    }

    public boolean verificarePat(String pol1)
    {
        String modelPol = "([+-]?(?:(?:\\d*X\\^\\d+)|(?:\\d+X)|(?:\\d+)|(?:X)))";
        Pattern pattern = Pattern.compile(modelPol);
        Matcher matcher = pattern.matcher(pol1);
        if(matcher.matches()) {
            return true;
        }
        else
        {
            return false;
        }
    }

}

