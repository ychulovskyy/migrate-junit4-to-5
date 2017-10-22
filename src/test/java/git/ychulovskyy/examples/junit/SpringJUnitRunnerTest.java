package git.ychulovskyy.examples.junit;

import git.ychulovskyy.examples.junit.tools.SlowTests;
import groovy.lang.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@Category(SlowTests.class)
@ContextConfiguration(classes = MyContext.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application.properties")
public class SpringJUnitRunnerTest {

    @Autowired
    private CalculationService calculationService;

    @Test
    public void testCalculation() {
        assertEquals(2, calculationService.add(1,1));
    }
}
