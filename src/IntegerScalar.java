import java.util.NoSuchElementException;
import java.lang.Math;
public class IntegerScalar implements Scalar{
    private int number;
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
}
