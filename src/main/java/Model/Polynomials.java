package Model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomials {
    private Map<Integer,Double> polynomial;
    private List<Monomials> listMonom;
    private GuiModel model;
    private Boolean verifPol;

    public Polynomials(Map<Integer,Double> polynomials) {
        listMonom = new ArrayList<>();
        this.polynomial = polynomials;
    }

    public Polynomials() {
        listMonom = new ArrayList<>();
        this.polynomial = new HashMap<>();
    }

    public Map<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public Polynomials(String pol) {

            polynomial = new HashMap();
            listMonom = new ArrayList<>();
            verifPol = true;
            model = new GuiModel();
            if(!Objects.equals(pol, ""))
            {
                pol = pol.replace("-","+-");
                if(pol.charAt(0) == '+' && pol.charAt(1) == '-')
                {
                    pol = pol.substring(1,pol.length());
                }
                List<String> polString = Arrays.asList(pol.split("\\+"));
                for (String monom: polString) {
                    {
                        if(!model.verificarePat(monom) && verifPol) {
                            verifPol = false;
                            break;
                        }
                        String freeelem = "[0-9]+";
                        Pattern pattern = Pattern.compile(freeelem);
                        Matcher matcher = pattern.matcher(monom);
                        int power;
                        Double coef = 0.0;
                        if(matcher.matches()) {
                            power = 0;
                            coef = Double.parseDouble(monom);
                        }
                        else {
                            for(int i = 0; i < monom.length(); i++) {
                                if(monom.charAt(i) == 'X') {
                                    if(i == 0) {
                                        coef = 1.0;
                                        break;
                                    }
                                    else {
                                        coef = Double.parseDouble(monom.substring(0,i));
                                        break;
                                    }
                                }
                            }
                            if(monom.charAt(monom.length() - 1) == 'X') {
                                power = 1;
                            }
                            else {
                                power = Integer.parseInt(monom.substring(monom.lastIndexOf("^") + 1));
                            }
                        }
                        if(polynomial.containsKey(power)) {
                            polynomial.replace(power,polynomial.get(power) + coef);
                        }
                        else {
                            polynomial.put(power,coef);
                        }
                    }
                }

            }
            else {
                verifPol = false;
            }
    }
    public void transfMon() {
        for (Integer key: polynomial.keySet()) {
            listMonom.add(new Monomials(polynomial.get(key),key));
        }
    }
    public String stringPol()
    {String pol = "";
        if(listMonom.isEmpty())
            return "0";
        for (Monomials mono: listMonom) {
            if(mono.getPower() == 0)
            {
                if(mono.getCoeficient() < 0.0) {
                    pol = pol + mono.getCoeficient();
                }
                else {
                    pol = pol + "+" + mono.getCoeficient();
                }
            }
            else {
                if(mono.getCoeficient() < 0.0) {
                    pol = pol + mono.getCoeficient() + "X^" + mono.getPower();
                }
                else {
                    pol = pol + "+" + mono.getCoeficient() + "X^" + mono.getPower();
                }
            }
        }
        if(pol.charAt(0) == '+') {
            pol = pol.substring(1,pol.length());
        }
        return pol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomials that = (Polynomials) o;
        return Objects.equals(polynomial, that.polynomial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polynomial, listMonom);
    }

    public Boolean getVerifPol() {
        return verifPol;
    }
}
