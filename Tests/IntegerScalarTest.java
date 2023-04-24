import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerScalarTest {
    private IntegerScalar is1;
    private IntegerScalar is2;
    private IntegerScalar is3;
    private IntegerScalar is4;
    private IntegerScalar is5;

    @BeforeEach
    void setUp() {
        is1 = new IntegerScalar(1);
        is2 = new IntegerScalar(0);
        is3 = new IntegerScalar(-1);
        is4 = new IntegerScalar(2);
        is5 = new IntegerScalar(-2);



    }

    @Test
    void test_getNumber() {
    }

    @Test
    void test_add() {
    }

    @Test
    void test_mul() {
    }

    @Test
    void test_neg() {
    }

    @Test
    void test_power() {
    }

    @Test
    void test_sign() {
    }

    @Test
    void test_equals() {
    }

    @Test
    void test_toString() {
        assertEquals("1", is1.toString());
        assertEquals("", is2.toString());
        assertEquals("-1", is3.toString());
        assertEquals("2", is4.toString());
        assertEquals("-2", is5.toString());

    }
}