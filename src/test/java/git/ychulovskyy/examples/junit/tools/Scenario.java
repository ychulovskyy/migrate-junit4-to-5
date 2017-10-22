package git.ychulovskyy.examples.junit.tools;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public interface Scenario {
    @TestFactory
    default Collection<DynamicTest> scenario() {
        final List<Method> methods = Stream.of(getClass().getMethods())
                .filter(m -> !Modifier.isStatic(m.getModifiers()))
                .filter(m -> m.getParameterCount() == 0)
                .filter(m -> !m.isAnnotationPresent(Disabled.class))
                .filter(m -> m.getName().startsWith("step"))
                .collect(toList());
        methods.sort(Comparator.comparing(Method::getName));
        return methods.stream()
                .map(m -> dynamicTest(m.getName(), () -> m.invoke(this)))
                .collect(toList());
    }
}
