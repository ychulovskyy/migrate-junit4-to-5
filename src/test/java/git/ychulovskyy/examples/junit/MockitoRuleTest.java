package git.ychulovskyy.examples.junit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class MockitoRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        // do something here
    }

    @Test
    public void testSomething() {
        assertEquals(1, 1);
    }
}
