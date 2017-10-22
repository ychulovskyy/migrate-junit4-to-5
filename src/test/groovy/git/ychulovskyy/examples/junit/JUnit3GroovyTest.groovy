package git.ychulovskyy.examples.junit

import git.ychulovskyy.examples.junit.tools.GroovyAssertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assumptions.assumeTrue

class JUnit3GroovyTest extends GroovyAssertions {

    @BeforeEach
    void setup() {
        // do something here
    }

    @Test
    void dummyTest() {
        assumeTrue '' == ''
        assert 1 == 1
    }

    @Test
    void testExceptionMessage() {
        def message = shouldFail { throwException() }.message

        assert message == 'exception message'
    }

    private static throwException() {
        throw new RuntimeException('exception message')
    }
}
