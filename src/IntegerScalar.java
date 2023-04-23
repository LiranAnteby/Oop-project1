import java.lang.Math;
public class IntegerScalar implements Scalar{
    private final int number;
    public IntegerScalar(int n){
        this.number = n;
    }
    public int getNumber() {
        return number;
    }

    public Scalar add(Scalar s) {
        return s.add(this);
    }
    private Scalar add(IntegerScalar s){
        return new IntegerScalar(number + s.getNumber());
    }
    private Scalar add(RationalScalar s){
        return s.add(new RationalScalar(number,1));
    }
    public Scalar mul(Scalar s){
        return s.mul(this);
    }
    private Scalar mul(IntegerScalar s){
        return new IntegerScalar(number * s.getNumber());
    }
    private Scalar mul(RationalScalar s){
        return s.mul(new RationalScalar(number,1));
    }
    public Scalar neg(){
        return new IntegerScalar(-number);
    }

    public Scalar power(int exponent){
        return new IntegerScalar((int)Math.pow(number,exponent));
    }

    public int sign(){
        return Integer.signum(number);
    }

    public boolean equals(Object o){
        if (! (o instanceof Scalar)) return false;
        if (o instanceof IntegerScalar) return ((IntegerScalar) o).getNumber() == number;
        else
            return ( ((RationalScalar)o).getNumerator() / ((RationalScalar)o).getDenominator() == number);
    }
    public String toString(){
        return "" + number;
    }
}
