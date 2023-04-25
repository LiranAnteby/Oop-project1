public class IntegerScalarTests {

    public void testAdd() {
        // tries to add two Integer Scalars.
        Scalar integerScalar1 = new IntegerScalar(50);
        Scalar integerScalar2 = new IntegerScalar(-15);
        boolean success1 = (integerScalar1.add(integerScalar2).equals(new IntegerScalar(35)));
        if (success1) System.out.println("Added two Integers successfully!");
        else System.out.println("Add two Integers failed!");

        // tries to add Integer with Rational,
        // and Rational with Integer.
        Scalar rationalScalar1 = new RationalScalar(2,5);
        boolean success2 = (integerScalar1.add(rationalScalar1).equals(new RationalScalar(252,5)))&&
                            (rationalScalar1.add(integerScalar1).equals(new RationalScalar(252,5)));
        if (success2) System.out.println("Added Integer with Rational successfully!");
        else System.out.println("Add Integer with Rational failed!");

        // tries to add Integer with a negative Rational.
        Scalar rationalScalar2 = new RationalScalar(-2,5);
        boolean success3 = (integerScalar1.add(rationalScalar2).equals(new RationalScalar(248,5))) &&
                            (rationalScalar2.add(integerScalar1).equals(new RationalScalar(248,5)));
        if (success3) System.out.println("Added Integer with negative Rational successfully!");
        else System.out.println("Add Integer with negative Rational failed!");
    }

    public void testMul(){
        // Tries to multiply two Integers.
        Scalar integerScalar1 = new IntegerScalar(5);
        Scalar integerScalar2 = new IntegerScalar(-15);
        boolean success1 = (integerScalar1.mul(integerScalar2).equals(new IntegerScalar(-75)));
        if (success1) System.out.println("Doubled two Integers successfully!");
        else System.out.println("Double two Integers failed!");

        // tries to multiply Integer with Rational,
        // and Rational with Integer.
        Scalar rationalScalar1 = new RationalScalar(2,5);
        boolean success2 = (integerScalar1.mul(rationalScalar1).equals(new IntegerScalar(2)))&&
                (rationalScalar1.mul(integerScalar1).equals(new IntegerScalar(2)));
        if (success2) System.out.println("Doubled Integer with Rational successfully!");
        else System.out.println("Double Integer with Rational failed!");

        // tries to multiply Integer with a negative Rational.
        Scalar rationalScalar2 = new RationalScalar(-2,5);
        boolean success3 = (integerScalar1.mul(rationalScalar2).equals(new IntegerScalar(-2))) &&
                (rationalScalar2.mul(integerScalar1).equals(new IntegerScalar(-2)));
        if (success3) System.out.println("Doubled Integer with negative Rational successfully!");
        else System.out.println("Double Integer with negative Rational failed!");
    }

    public void testNeg(){
        // make sure it returns the right Integer.
        Scalar integerScalar1 = new IntegerScalar(5);
        boolean success1 = (integerScalar1.neg().equals(new IntegerScalar(-5)));
        if (success1) System.out.println("Negated an Integer successfully!");
        else System.out.println("Negate an Integer failed!");
    }

    public void testPower(){
        // Tries to power regular.
        Scalar integerScalar1 = new IntegerScalar(5);
        boolean success1 = (integerScalar1.power(3).equals(new IntegerScalar(125)));
        if (success1) System.out.println("Powered an Integer successfully!");
        else System.out.println("Power failed!");

        // tries to power negative Integer with odd exponent.
        Scalar integerScalar2 = new IntegerScalar(-5);
        boolean success2 = (integerScalar1.power(3).equals(new IntegerScalar(-125)));
        if (success2) System.out.println("Powered a negative Integer successfully!");
        else System.out.println("Power failed!");
    }

    public void testSign(){
        // Check if sign in correct.
        Scalar integerScalar1 = new IntegerScalar(5);
        Scalar integerScalar2 = new IntegerScalar(-5);
        Scalar integerScalar3 = new IntegerScalar(0);
        boolean success1 = (integerScalar1.sign() == 1) & (integerScalar2.sign() == -1) & (integerScalar3.sign() == 0);
        if (success1) System.out.println("sign is correct!");
        else System.out.println("Power failed!");
    }

    public void testEquals(){
        // Check for two Integers.
        Scalar integerScalar1 = new IntegerScalar(5);
        Scalar integerScalar2 = new IntegerScalar(5);
        Scalar integerScalar3 = new IntegerScalar(-5);
        boolean success1 = (integerScalar1.equals(integerScalar2)) & !(integerScalar1.equals(integerScalar3));
        if (success1) System.out.println("Equals is correct!");
        else System.out.println("Equals failed!");

        // Check for Integer and Rational.
        Scalar rationalScalar1 = new RationalScalar(10,2);
        boolean success2 = integerScalar1.equals(rationalScalar1);
        if (success2) System.out.println("Equals is correct!");
        else System.out.println("Equals failed!");
    }

}
