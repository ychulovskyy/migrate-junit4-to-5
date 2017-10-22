package git.ychulovskyy.examples.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoRunnerTest {

    @Mock
    private CalculationService calculationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWithMocks() {
        when(calculationService.add(1, 1)).thenReturn(3);
        assertEquals(3, calculationService.add(1, 1));
    }
}
