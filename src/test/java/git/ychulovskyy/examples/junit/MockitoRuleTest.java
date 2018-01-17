package git.ychulovskyy.examples.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class MockitoRuleTest {

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        // do something here
        System.out.println("Run before each");
    }

    @BeforeAll
    static void runOnce() {
        System.out.println("Run before all");
    }

    @Test
    void testSomething() {
        System.out.println("Run test");
        assertEquals(1, 1, () -> "failure message");
        assertThat("tw", notNullValue());

        assertAll(
                () -> assertEquals(1, 1),
                () -> assertEquals(2, 2)
        );

        NumberFormatException nfe = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("some text");
        });
    }

    @ParameterizedTest
    @CsvSource({"foo, 1", "bar, 2"})
    void testWithParameters(String parameter, int i) {
        System.out.println(parameter + i);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testWithParameters2(String parameter) {
        System.out.println(parameter);
    }

    private static Iterable<String> testDataProvider() {
        return asList("foo", "bar");
    }

    @Nested
    @DisplayName("Tests for the method A")
    class A {

        @BeforeEach
        void beforeEach() {
            System.out.println("Before each test method of the A class");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each test method of the A class");
        }

        @Test
        @DisplayName("Example test for method A")
        void sampleTestForMethodA() {
            System.out.println("Example test for method A");
        }

        @Test
        @DisplayName("Another test")
        void anotherTestForMethodA() {
            System.out.println("Another test");
        }
    }
}
