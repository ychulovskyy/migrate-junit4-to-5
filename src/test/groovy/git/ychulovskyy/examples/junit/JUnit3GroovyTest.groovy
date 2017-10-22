package git.ychulovskyy.examples.junit

import org.junit.Before
import org.junit.Test

import static org.hamcrest.core.IsEqual.equalTo
import static org.junit.Assume.assumeThat

class JUnit3GroovyTest extends GroovyTestCase {

    @Before
    void setup() {
        // do something here
    }

    @Test
    void dummyTest() {
        assumeThat '' , equalTo('')
        assert 1 == 1
    }

    @Test
    void testExceptionMessage() {
        def message = shouldFail { throwException() }

        assert message == 'exception message'
    }

    private static throwException() {
        throw new RuntimeException('exception message')
    }
}
