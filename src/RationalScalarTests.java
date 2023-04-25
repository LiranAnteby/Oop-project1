public class RationalScalarTests {

    public void testAdd() {
        // tries to add two Rational Scalars.
        Scalar rational1 = new RationalScalar(2,3);
        Scalar rational2 = new RationalScalar(1,4);
        Scalar rational3 = new RationalScalar(1,-4);
        boolean success1 = (rational1.add(rational2).equals(new RationalScalar(11,12)))&&
                (rational1.add(rational3).equals(new RationalScalar(5,12)))&&
                (rational2.add(rational3).equals(new IntegerScalar(0)));
        if (success1) System.out.println("Added two Rationals successfully!");
        else System.out.println("Add two Rationals failed!");

        //Did tests for adding Integer and Rational in "IntegerScalarTests"!
    }

    public void testMul(){
        Scalar rational1 = new RationalScalar(2,3);
        Scalar rational2 = new RationalScalar(1,4);
        Scalar rational3 = new RationalScalar(4,-1);
        boolean success1 = (rational1.mul(rational2).equals(new RationalScalar(2,12)))&&
                (rational1.mul(rational3).equals(new RationalScalar(-8,3)))&&
                (rational2.mul(rational3).equals(new IntegerScalar(-1)));
        if (success1) System.out.println("Multiplied two Rationals successfully!");
        else System.out.println("Multiplied two Rationals failed!");

        //Did tests for multiplying Integer and Rational in "IntegerScalarTests"!
    }

    public void testNeg(){
        // make sure it returns the right Rational.
        Scalar rational1 = new RationalScalar(5,3);
        boolean success1 = (rational1.neg().equals(new RationalScalar(-5,3)));
        if (success1) System.out.println("Negated a Rational successfully!");
        else System.out.println("Negate a Rational failed!");
    }

    public void testPower(){
        // Tries to power regular.
        Scalar rational1 = new RationalScalar(5,3);
        boolean success1 = (rational1.power(3).equals(new RationalScalar(125,9)));
        if (success1) System.out.println("Powered a Rational successfully!");
        else System.out.println("Power failed!");

        // tries to power negative Rational with odd exponent.
        Scalar rational2 = new RationalScalar(-5,3);
        boolean success2 = (rational2.power(3).equals(new RationalScalar(-125,9)));
        if (success2) System.out.println("Powered a negative Rational successfully!");
        else System.out.println("Power failed!");
    }

    public void testSign(){
        // Check if sign in correct.
        Scalar rational1 = new RationalScalar(5,3);
        Scalar rational2 = new RationalScalar(-5,3);
        Scalar rational3 = new RationalScalar(0,3);
        boolean success1 = (rational1.sign() == 1) & (rational2.sign() == -1) & (rational3.sign() == 0);
        if (success1) System.out.println("sign is correct!");
        else System.out.println("Power failed!");
    }

    public void testEquals(){
        // Check for two Integers.
        Scalar rational1 = new RationalScalar(5,3);
        Scalar rational2 = new RationalScalar(5,3);
        Scalar rational3 = new RationalScalar(-5,3);
        boolean success1 = (rational1.equals(rational2)) & !(rational1.equals(rational3));
        if (success1) System.out.println("Equals is correct!");
        else System.out.println("Equals failed!");

        // Checked for Integer and Rational in "IntegerScalarTests"!
    }

}
