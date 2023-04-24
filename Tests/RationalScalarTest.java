import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalScalarTest {
    private RationalScalar rs1;
    private RationalScalar rs2;
    private RationalScalar rs3;
    private RationalScalar rs4;
    private RationalScalar rs5;
    private RationalScalar rs6;
    private RationalScalar rs7;

    @BeforeEach
    void setUp() {
        rs1 = new RationalScalar(1,2);
        rs2 = new RationalScalar(0,1);
        rs3 = new RationalScalar(-5,4);
        rs4 = new RationalScalar(5,-4);
        rs5 = new RationalScalar(4,8);
        rs6 = new RationalScalar(-5,2);
        rs7 = new RationalScalar(1,1);
    }


    @Test
    void test_add() {
        assertEquals(rs6,rs3.add(rs4));
        assertEquals(rs1,rs1.add(rs2));
        assertEquals(rs7,rs1.add(rs5));

    }

    @Test
    void mul() {
    }

    @Test
    void neg() {
    }

    @Test
    void power() {
    }

    @Test
    void sign() {
    }

    @Test
    void testEquals() {
        assertTrue(rs1.equals(rs5));
        assertTrue(rs3.equals(rs4));
        assertFalse(rs1.equals(rs3));
        assertTrue(rs2.equals(new IntegerScalar(0)));
        assertFalse(rs3.equals(new IntegerScalar(-1)));
    }

    @Test
    void testToString() {
        assertEquals("1/2", rs1.toString());
        assertEquals("0", rs2.toString());
        assertEquals("-5/4", rs3.toString());
        assertEquals("-5/4", rs4.toString());
        assertEquals("1/2", rs5.toString());

    }

    @Test
    void test_reduce() {

    }
}