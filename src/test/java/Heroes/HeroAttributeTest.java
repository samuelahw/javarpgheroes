package Heroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {

    HeroAttribute attribute;
    @Test
    void test_returnStat_shouldReturnInt() {
        attribute = new HeroAttribute(0);
        int expected = 0;
        int actual = attribute.returnStat();

        assertEquals(expected, actual);
    }

}