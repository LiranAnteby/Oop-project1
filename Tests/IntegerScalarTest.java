import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerScalarTest {
    private IntegerScalar is1;
    private IntegerScalar is2;
    private IntegerScalar is3;
    private IntegerScalar is4;
    private IntegerScalar is5;
    private IntegerScalar is6;


    @BeforeEach
    void setUp() {
        is1 = new IntegerScalar(1);
        is2 = new IntegerScalar(0);
        is3 = new IntegerScalar(-1);
        is4 = new IntegerScalar(2);
        is5 = new IntegerScalar(3);
        is6 = new IntegerScalar(-3);

    }

    @Test
    void test_getNumber() {
        assertEquals(1,is1.getNumber());
        assertEquals(0,is2.getNumber());
        assertEquals(-1,is3.getNumber());
        assertEquals(2,is4.getNumber());
        assertEquals(3,is5.getNumber());
        assertEquals(-3,is6.getNumber());

    }

    @Test
    void test_add() {
        assertEquals(is2,is1.add(is3));
        assertEquals(is5,is4.add(is1));
        assertEquals(is1,is4.add(is3));
        assertEquals("-2",is6.add(is1).toString());
    }

    @Test
    void test_mul() {
        assertEquals("-1",is1.mul(is3).toString());
        assertEquals("3",is3.mul(is6).toString());
        assertEquals("",is2.mul(is3).toString());
        assertEquals("6",is4.mul(is5).toString());
    }

    @Test
    void test_neg() {
        assertEquals("-3",is5.neg().toString());
        assertEquals("1",is3.neg().toString());
        assertEquals("",is2.neg().toString());
    }

    @Test
    void test_power() {
        assertEquals("1",is1.power(200).toString());
        assertEquals("-1",is3.power(3).toString());
        assertEquals("8",is4.power(3).toString());
        assertEquals("",is2.power(3).toString());
        assertEquals("1",is3.power(0).toString());
    }

    @Test
    void test_sign() {
        assertEquals(1,is1.sign());
        assertEquals(0,is2.sign());
        assertEquals(-1,is3.sign());
    }

    @Test
    void test_equals() {
        assertEquals(true,is1.equals(is1));
        assertEquals(false,is5.equals(is6));
    }

    @Test
    void test_toString() {
        assertEquals("1", is1.toString());
        assertEquals("", is2.toString());
        assertEquals("-1", is3.toString());
        assertEquals("2", is4.toString());
    }
}