package Model;

public class  Monomials {
    private Double coeficient;
    private int power;

    public Double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Monomials(Double coeficient, int power) {
        this.coeficient = coeficient;
        this.power = power;
    }

}
