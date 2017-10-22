package git.ychulovskyy.examples.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IgnoreTest {

    @Disabled
    @Test
    public void testSomething() {
        assertEquals(1, 1);
    }
}
