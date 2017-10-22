package git.ychulovskyy.examples.junit

import git.ychulovskyy.examples.junit.tools.GroovyAssertions
import org.junit.jupiter.api.Test

class JUnit4GroovyAssert extends GroovyAssertions {

    @Test
    void someTest() {
        assert 1 == 1
    }
}
