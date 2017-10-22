package git.ychulovskyy.examples.junit;

import git.ychulovskyy.examples.junit.tools.IgnoreAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class XmlDiffTest {
    private final static String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    @Test
    public void testDiff() throws IOException, SAXException {
        Diff diffs = new Diff(HEADER + "<test attribute1=\"1\"/>", HEADER + "<test attribute1=\"2\"/>");
        diffs.overrideDifferenceListener(new IgnoreAttributeValuesDifferenceListener());
        assertTrue(diffs.similar());
    }
}
