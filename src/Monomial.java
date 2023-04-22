public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Monomial add (Monomial m){
        if (m.exponent != this.exponent) return null;
        return new Monomial(exponent,coefficient.add(m.coefficient));
    }
    public Monomial mul(Monomial m){
        return new Monomial(exponent + m.exponent,coefficient.mul(m.coefficient));
    }
    public Scalar evaluate(Scalar s){
        return s.power(exponent).mul(coefficient);
    }
    public Monomial derivative(){
        if (exponent == 0)
            return new Monomial(0,new IntegerScalar(0));
        return new Monomial(exponent-1,coefficient.mul(new IntegerScalar(exponent)));
    }
    public int sign(){
        return coefficient.sign();
    }
    public boolean equals(Object o){
        if (! (o instanceof Monomial)) return false;
        if (((Monomial) o).exponent != exponent) return false;
        if (!((Monomial) o).coefficient.equals(coefficient)) return false;
        return true;
    }
    public String toString(){
        if (coefficient.equals(new IntegerScalar(1)))
            return "x^" + exponent;
        if (coefficient.equals(new IntegerScalar(-1)))
            return "-x^" + exponent;
        if (exponent == 0)
            return coefficient.toString();
        if (coefficient.equals(new IntegerScalar(0)))
            return "0";
        return coefficient.toString() + "x^" + exponent;
    }
}
