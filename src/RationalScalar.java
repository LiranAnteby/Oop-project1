import java.util.NoSuchElementException;

public class RationalScalar implements Scalar {
    private final int numerator;
    private final int denominator;
    public RationalScalar(int numerator,int denominator){
        if (denominator == 0) throw new IllegalArgumentException("Denominator mustn't be 0!");
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
        int tempN = (int)Math.pow(numerator,exponent);
        int tempD = (int)Math.pow(denominator,exponent);
        return new RationalScalar(tempN,tempD);
    }

    public int sign(){
        if (numerator == 0) return 0;
        if ((numerator > 0 && denominator > 0) | (numerator < 0 && denominator < 0)) return 1;
        return -1;
    }

    public boolean equals(Object o){
        if (! (o instanceof Scalar)) return false;
        return true;
    }
    public String toString(){
        RationalScalar reducedThis = new RationalScalar(numerator,denominator).reduce();
        int reducedN = reduce().numerator , reducedD = reducedThis.denominator;
        if (reducedD == 1 | reducedD == -1)
            return "" + reducedN;
        if(reducedThis.sign() == -1)
            return "-" + Math.abs(reducedN) + "/" + Math.abs(reducedD);
        return "" + Math.abs(reducedN) + "/" + Math.abs(reducedD);

    }
    // using the GCD Algorithm.
    public RationalScalar reduce(){
        if (numerator == 0) return new RationalScalar(0,1);
        int gcd = 1, tempN = numerator, tempD = denominator;
        boolean isNegN = false, isNegD = false;
        if (tempN<0) {
            tempN = -tempN;
            isNegN = true;
        }
        if (tempD <0){
            tempD = -tempD;
            isNegD = true;
        }

        while(tempN != tempD)
        {
            if(tempN > tempD)
                tempN = tempN - tempD;
            else
                tempD = tempD - tempN;
        }
        if (isNegD & isNegN)
            gcd = -gcd;
        return new RationalScalar(numerator/gcd,denominator/gcd);
    }
}