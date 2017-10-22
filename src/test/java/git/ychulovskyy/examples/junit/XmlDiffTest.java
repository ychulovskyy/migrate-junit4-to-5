package git.ychulovskyy.examples.junit;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import org.xmlunit.builder.DiffBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class XmlDiffTest {
    private final static String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    private final static Set<String> IGNORED_ATTRIBUTES = new HashSet<>(Arrays.asList("attribute1", "attribute2"));

    @Test
    public void testDiff() throws IOException, SAXException {

        assertFalse(DiffBuilder.compare(HEADER + "<test attribute1=\"1\"/>").withTest(HEADER + "<test attribute1=\"2\"/>")
                .withAttributeFilter(node -> !IGNORED_ATTRIBUTES.contains(node.getNodeName()))
                .ignoreWhitespace()
                .checkForSimilar()
                .build()
                .hasDifferences());
    }
}
