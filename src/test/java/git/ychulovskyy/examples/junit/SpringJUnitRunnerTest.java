package git.ychulovskyy.examples.junit;

import git.ychulovskyy.examples.junit.tools.SlowTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag(SlowTests.SLOW)
@ContextConfiguration(classes = MyContext.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application.properties")
public class SpringJUnitRunnerTest {

    @Autowired
    private CalculationService calculationService;

    @Test
    public void testCalculation() {
        assertEquals(2, calculationService.add(1, 1));
    }
}
