package git.ychulovskyy.examples.junit.tools

import org.codehaus.groovy.runtime.ScriptBytecodeAdapter

import static org.junit.jupiter.api.Assertions.assertTrue

/**
 * This class contains copy of a few groovy.test.org.junit.jupiter.api methods.
 * It's needed to avoid coupling with JUnit 4.
 * 1. Maybe testing should be part of a library, not a language?
 * Because now we have to wait for new Groovy release to get support of JUnit 5.
 * It's easier and quicker to release a new version of tiny test library.
 * 2. We already have GroovyTestCase for JUnit 3 and GroovyAssert for JUnit 4.
 * Now a new class should be created to support JUnit 5.
 * Maybe it worth to include JUnit version into class name to avoid confusion?
 */
class GroovyAssertions {
    static Throwable shouldFail(Closure code) {
        boolean failed = false
        Throwable th = null
        try {
            code.call()
        } catch (GroovyRuntimeException gre) {
            failed = true
            th = ScriptBytecodeAdapter.unwrap(gre)
        } catch (Throwable e) {
            failed = true
            th = e
        }
        assertTrue failed, 'Closure ' + code + ' should have failed'
        th
    }
}
