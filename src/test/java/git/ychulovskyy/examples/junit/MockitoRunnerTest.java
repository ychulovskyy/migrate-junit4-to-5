package git.ychulovskyy.examples.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoRunnerTest {

    @Mock
    private CalculationService calculationService;

    @Test
    public void testWithMocks() {
        when(calculationService.add(1, 1)).thenReturn(3);
        assertEquals(3, calculationService.add(1, 1));
    }
}
