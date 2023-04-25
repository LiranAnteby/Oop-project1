import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Monomial monomial1;
    private Monomial monomial2;
    private Monomial monomial3;
    private Monomial monomial4;
    private Monomial monomial5;
    private Monomial monomial6;
    @BeforeEach
    void setUp() {
        monomial1 = new Monomial(1, new IntegerScalar(2));
        monomial2 = new Monomial(0, new IntegerScalar(1));
        monomial3 = new Monomial(3, new IntegerScalar(-4));
        monomial4 = new Monomial(3, new RationalScalar(-5,3));
        monomial5 = new Monomial(3, new RationalScalar(-17,3));
        monomial6 = new Monomial(3, new RationalScalar(-10,6));
    }
    @Test
    void add() {
        assertNull(monomial1.add(monomial3));
        assertEquals(monomial5,monomial3.add(monomial4));
    }

    @Test
    void mul() {
        assertEquals(monomial3,monomial3.mul(monomial2));
        assertEquals(new Monomial(4,new RationalScalar(-10,3)),monomial4.mul(monomial1));
    }

    @Test
    void evaluate() {
        assertEquals(new IntegerScalar(6),monomial1.evaluate(new IntegerScalar(3)));
        assertEquals(new IntegerScalar(1),monomial2.evaluate(new IntegerScalar(7)));
        assertEquals(new IntegerScalar(-32),monomial3.evaluate(new IntegerScalar(2)));
        assertEquals(new RationalScalar(-72,25),monomial4.evaluate(new RationalScalar(6,5)));
    }

    @Test
    void derivative() {
        assertEquals(new Monomial(0,new IntegerScalar(0)),monomial2.derivative());
        assertEquals(new Monomial(2,new IntegerScalar(-5)),monomial4.derivative());
    }

    @Test
    void sign() {
        assertEquals(-1,monomial5.sign());
        assertEquals(1,monomial1.sign());
        assertEquals(0,new Monomial(5,new IntegerScalar(0)).sign() );
    }

    @Test
    void testEquals() {
        assertFalse(monomial1.equals(monomial2));
        assertTrue(monomial4.equals(monomial6));
    }

    @Test
    void testToString() {
        assertEquals("2x",monomial1.toString());
        assertEquals("1",monomial2.toString());
        assertEquals("-4x^3",monomial3.toString());
        assertEquals("-5/3x^3",monomial4.toString());
    }
}