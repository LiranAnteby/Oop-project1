import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Monomial monomial1;
    private Monomial monomial2;
    private Monomial monomial3;
    private Monomial monomial4;
    private Monomial monomial5;


    @BeforeEach
    void setUp() {
        monomial1 = new Monomial(1, new IntegerScalar(2));
        monomial2 = new Monomial(0, new IntegerScalar(1));
        monomial3 = new Monomial(3, new IntegerScalar(-4));
        monomial4 = new Monomial(3, new RationalScalar(-5,3));



    }

    @Test
    void getExponent() {
    }

    @Test
    void getCoefficient() {
    }

    @Test
    void add() {
        assertEquals("2x",monomial1.add(monomial3));

    }

    @Test
    void mul() {
    }

    @Test
    void evaluate() {
    }

    @Test
    void derivative() {
    }

    @Test
    void sign() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testToString() {
        assertEquals("2x",monomial1.toString());
        assertEquals("1",monomial2.toString());
        assertEquals("-4x^3",monomial3.toString());
        assertEquals("-5/3x^3",monomial4.toString());




    }
}