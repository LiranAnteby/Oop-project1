import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    private Polynomial polynomial1;
    private Polynomial polynomial2;
    private Polynomial polynomial3;
    private Polynomial polynomial4;
    private Polynomial polynomial5;
    private Polynomial polynomial6;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        polynomial1 = Polynomial.build("1 2 3");
        polynomial2 = Polynomial.build("0 1 2 3");
        polynomial3 = Polynomial.build("0 0 0 0 0 0 7");
        polynomial4 = Polynomial.build("5");
        polynomial5 = Polynomial.build("1 -2 3");
        polynomial6 = Polynomial.build("0 1/2 3 -5/3");
    }

    @org.junit.jupiter.api.Test
    void build() {
        assertEquals("1+2x+3x^2",polynomial1.toString());
        assertEquals("1x+2x^2+3x^3",polynomial2.toString());
        assertEquals("7x^6",polynomial3.toString());
        assertEquals("5",polynomial4.toString());
        assertEquals("1-2x+3x^2",polynomial5.toString());
        //assertEquals("1/2x+3x^2-5/3x^3",polynomial6.toString());
    }

    @org.junit.jupiter.api.Test
    void test_add() {
        //assertEquals("1+3x+5x^2+3x^3",polynomial1.add(polynomial2).toString());
        assertEquals("6+2x+3x^2",polynomial1.add(polynomial4).toString());
        //assertEquals("5+1/2x+3x^2-5/3x^3",polynomial4.add(polynomial6).toString());
        //assertEquals("x-2x^2+3x^3+7x^6",polynomial5.add(polynomial3).toString());
    }

    @org.junit.jupiter.api.Test
    void test_mul() {
        assertEquals("2x+6x^2+3x^3",polynomial1.mul(polynomial2).toString());
        assertEquals("5-2x+3x^2",polynomial4.mul(polynomial5).toString());
    }

    @org.junit.jupiter.api.Test
    void test_evaluate() {
        assertEquals("86",polynomial1.evaluate(new IntegerScalar(5)).toString());
        assertEquals("448",polynomial3.evaluate(new IntegerScalar(2)).toString());
        assertEquals("7",polynomial3.evaluate(new IntegerScalar(1)).toString());
        assertEquals("5",polynomial4.evaluate(new IntegerScalar(60)).toString());
        assertEquals("-1/3",polynomial6.evaluate(new IntegerScalar(2)).toString());
        assertEquals("2",polynomial6.evaluate(new RationalScalar(1, 3)).toString());
    }

    @org.junit.jupiter.api.Test
    void test_derivative() {
        assertEquals("2+6x",polynomial1.derivative().toString());
        assertEquals("1+4x+9x^2",polynomial2.derivative().toString());
        assertEquals("42x^5",polynomial3.derivative().toString());
        assertEquals("",polynomial4.derivative().toString());
        assertEquals("-2+6x",polynomial6.derivative().toString());
        assertEquals("1/2+6x-5x^2",polynomial6.derivative().toString());
    }

    @org.junit.jupiter.api.Test
    void test_equals() {
        assertEquals(true,polynomial6.equals(polynomial6));
        assertEquals(false,polynomial1.equals(polynomial6));

    }

    @org.junit.jupiter.api.Test
    void test_toString() {
        assertEquals("1+2x+3x^2",polynomial1.toString());
        assertEquals("1x+2x^2+3x^3",polynomial2.toString());
        assertEquals("7x^6",polynomial3.toString());
        assertEquals("5",polynomial4.toString());
        assertEquals("1-2x+3x^2",polynomial5.toString());
        //assertEquals("1/2x+3x^2-5/3x^3",polynomial6.toString());
    }
}