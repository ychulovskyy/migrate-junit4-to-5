package git.ychulovskyy.examples.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = MyContext.class)
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
public class SpringRunnerTest {

    @Autowired
    private CalculationService calculationService;

    @Test
    public void testCalculation() {
        assertEquals(2, calculationService.add(1, 1));
    }
}
