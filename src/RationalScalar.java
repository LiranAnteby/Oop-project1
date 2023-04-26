
public class RationalScalar implements Scalar {
    private final int numerator;
    private final int denominator;
    public RationalScalar(int numerator,int denominator){
        if (denominator == 0) throw new IllegalArgumentException("Denominator mustn't be 0!");
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Scalar add(Scalar s) {
        return s.add(this);
    }
    public Scalar add(IntegerScalar s){
        if(numerator == 0 ) return s;
        if (s.getNumber() == 0 )return this;
        return new RationalScalar((s.getNumber()*denominator + numerator),denominator).reduce();
    }
    public Scalar add(RationalScalar s){
        int tempN = numerator * s.getDenominator() + s.getNumerator() * denominator;
        int tempD = denominator * s.getDenominator();
        if (tempN%tempD == 0) return new IntegerScalar(tempN/tempD);
        return new RationalScalar(tempN, tempD).reduce();
    }
    public Scalar mul(Scalar s){
        return s.mul(this);
    }
    public Scalar mul(IntegerScalar s){
        return this.mul(new RationalScalar(s.getNumber(),1));
    }
    public Scalar mul(RationalScalar s){
        int tempN = numerator * s.getNumerator();
        int tempD = denominator * s.getDenominator();
        if (tempN%tempD == 0) return new IntegerScalar(tempN/tempD);
        return new RationalScalar(tempN,tempD).reduce();
    }

    public Scalar neg(){
        return new RationalScalar(-numerator,denominator).reduce();
    }

    public Scalar power(int exponent){
        int tempN = (int)Math.pow(numerator,exponent);
        int tempD = (int)Math.pow(denominator,exponent);
        return new RationalScalar(tempN,tempD).reduce();
    }

    public int sign(){
        if (numerator == 0) return 0;
        if ((numerator > 0 & denominator > 0) | (numerator < 0 & denominator < 0)) return 1;
        return -1;
    }

    public boolean equals(Object o){
        if (! (o instanceof Scalar)) return false;
        if (o instanceof IntegerScalar){
            int temp = ((IntegerScalar)o).getNumber();
            int rational = numerator/denominator, leftOver = numerator%denominator;
            return temp == rational && leftOver == 0 ;
        }
        else {
            RationalScalar rationalScalar = ((RationalScalar) o).reduce();
            return rationalScalar.getNumerator() / rationalScalar.getDenominator() == numerator / denominator;
        }
    }
    public String toString(){
        RationalScalar reducedThis = this.reduce();
        int reducedN = reducedThis.numerator , reducedD = reducedThis.denominator;
        if (reducedD == 1) return "" + reducedN;
        if (reducedD == -1) return "" + -reducedN;
        if(reducedThis.sign() == -1)
            return "-" + Math.abs(reducedN) + "/" + Math.abs(reducedD);
        return "" + reducedN + "/" + reducedD;

    }
    // using a GCD Algorithm.
    public RationalScalar reduce(){
        if (numerator == 0) return new RationalScalar(0,1);
        int tempN = numerator, tempD = denominator;
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
            tempD = -tempD;
        return new RationalScalar(numerator/tempD,denominator/tempD);
    }
}
