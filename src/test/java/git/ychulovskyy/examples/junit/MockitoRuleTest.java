package git.ychulovskyy.examples.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoRuleTest {

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // do something here
    }

    @Test
    public void testSomething() {
        assertEquals(1, 1);
    }
}
