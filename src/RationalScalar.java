import java.util.NoSuchElementException;

public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;
    public RationalScalar(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Scalar add(Scalar s) {
        throw new NoSuchElementException();
    }
    public Scalar mul(Scalar s){
        throw new NoSuchElementException();
    }

    public Scalar neg(){
        return new RationalScalar(-numerator,denominator);
    }

    public Scalar power(int exponent){
        return new IntegerScalar((int)Math.pow(number,exponent));
    }

    public int sign(){
        if (number > 0) return 1;
        else if (number < 0) return -1;
        else return 0;
    }

    public boolean equals(Object o){
        if (! (o instanceof Scalar)) return false;
        return true;
    }
    public String toString(){
        return "Your Integer Scalar is: " + number;
    }
    public RationalScalar reduce(){
        return new RationalScalar(numerator, 1);
    }
}
