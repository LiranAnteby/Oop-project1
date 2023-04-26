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
    private RationalScalar rs8;
    private RationalScalar rs9;
    private RationalScalar rs10;
    private RationalScalar rs11;
    private RationalScalar rs12;
    private IntegerScalar is1;


    @BeforeEach
    void setUp() {
        rs1 = new RationalScalar(1,2);
        rs2 = new RationalScalar(0,1);
        rs3 = new RationalScalar(-5,4);
        rs4 = new RationalScalar(5,-4);
        rs5 = new RationalScalar(4,8);
        rs6 = new RationalScalar(-5,2);
        rs7 = new RationalScalar(1,1);
        rs8 = new RationalScalar(-9,-3);
        rs9 = new RationalScalar(-3,-1);
        rs10 = new RationalScalar(25,16);
        rs11 = new RationalScalar(1,16);
        rs12 = new RationalScalar(-125,64);
        is1 = new IntegerScalar(-4);
    }


    @Test
    void test_add() {
        assertEquals(rs6,rs3.add(rs4));
        assertEquals(rs1,rs1.add(rs2));
        assertEquals(rs7,rs1.add(rs5));
        assertEquals(is1,rs2.add(is1));
    }

    @Test
    void test_mul() {
        assertEquals(rs2,rs1.mul(rs2));
        assertEquals(rs7,rs7.mul(rs7));
        assertEquals(rs12,rs10.mul(rs4));
        assertEquals(new IntegerScalar(-2),rs1.mul(is1));
    }

    @Test
    void test_neg() {
        assertNotEquals(rs3,rs4.neg());
        assertEquals(rs2,rs2.neg());
        assertEquals(rs3,rs4.neg().neg());

    }

    @Test
    void test_power() {
        assertEquals(rs7,rs7.power(5));
        assertEquals(rs10,rs3.power(2));
        assertEquals(rs11,rs5.power(4));
        assertEquals(rs12,rs4.power(3));
    }

    @Test
    void test_sign() {
        assertEquals(-1,rs3.sign());
        assertEquals(1,rs7.sign());
        assertEquals(0,rs2.sign());
        assertEquals(1,rs8.sign());
        assertEquals(-1,rs4.sign());
    }

    @Test
    void test_Equals() {
        assertTrue(rs1.equals(rs5));
        assertTrue(rs3.equals(rs4));
        assertFalse(rs1.equals(rs3));
        assertTrue(rs2.equals(new IntegerScalar(0)));
        assertFalse(rs3.equals(new IntegerScalar(-1)));
    }

    @Test
    void test_ToString() {
        assertEquals("1/2", rs1.toString());
        assertEquals("0", rs2.toString());
        assertEquals("-5/4", rs3.toString());
        assertEquals("-5/4", rs4.toString());
        assertEquals("1/2", rs5.toString());

    }

    @Test
    void test_reduce() {
        assertEquals(rs1,rs5.reduce());
        assertEquals(rs9,rs8.reduce());
    }
}