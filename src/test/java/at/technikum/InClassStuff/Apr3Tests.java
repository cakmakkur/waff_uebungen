package at.technikum.InClassStuff;

import at.technikum.LearningStuff.SomeCodeForTesting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Apr3Tests {
    @Test
    void isATagTest() {
        assertTrue(Apr3.isATagTestHelper("<abc>"));
        assertTrue(Apr3.isATagTestHelper("<abc234>"));
        assertFalse(Apr3.isATagTestHelper("<abc>>"));
        assertFalse(Apr3.isATagTestHelper("abc>"));
        assertFalse(Apr3.isATagTestHelper("</abc>"));
        assertFalse(Apr3.isATagTestHelper("abc"));
        assertFalse(Apr3.isATagTestHelper("<>abc>>"));
        assertFalse(Apr3.isATagTestHelper("<ab><<c>>"));
    }

    @Test
    void shouldReturnTrueIfStartingTag() {
        assertTrue(Apr3.isATagTestHelper("<wqer4>"));
        assertTrue(Apr3.isATagTestHelper("<wqe33r4>"));
        assertFalse(Apr3.isATagTestHelper("</wqer4>"));
        assertFalse(Apr3.isATagTestHelper("/wqer4>"));
        assertFalse(Apr3.isATagTestHelper("</wqer4"));
        assertFalse(Apr3.isATagTestHelper("<a/wqer4>"));
    }


/*    @Test
    void adderTest () {
        assertEquals(2, Apr3.adder(1 + 1));
    }*/


}
