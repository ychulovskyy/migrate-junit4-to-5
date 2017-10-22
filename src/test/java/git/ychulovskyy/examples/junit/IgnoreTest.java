package git.ychulovskyy.examples.junit;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IgnoreTest {

    @Ignore
    @Test
    public void testSomething() {
        assertEquals(1, 1);
    }
}
