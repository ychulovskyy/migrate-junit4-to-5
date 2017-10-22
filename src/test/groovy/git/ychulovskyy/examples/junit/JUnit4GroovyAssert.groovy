package git.ychulovskyy.examples.junit

import groovy.test.GroovyAssert
import org.junit.Test

class JUnit4GroovyAssert extends GroovyAssert {

    @Test
    void someTest() {
        assert 1 == 1
    }
}
