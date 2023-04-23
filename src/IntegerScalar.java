import java.util.NoSuchElementException;
import java.lang.Math;
public class IntegerScalar implements Scalar{
    private final int number;
    public IntegerScalar(int n){
        this.number = n;
    }
    public Scalar add(Scalar s) {
        throw new NoSuchElementException();
    }
    public Scalar mul(Scalar s){
        throw new NoSuchElementException();
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
        return true;
    }
    public String toString(){
        return "" + number;
    }
}
