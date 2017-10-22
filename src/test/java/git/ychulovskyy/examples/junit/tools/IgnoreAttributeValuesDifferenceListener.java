package git.ychulovskyy.examples.junit.tools;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IgnoreAttributeValuesDifferenceListener implements DifferenceListener {
    private final Set<String> blackList = new HashSet<>(Arrays.asList("attribute1", "attribute2"));

    @Override
    public int differenceFound(Difference difference) {
        return difference.getId() == DifferenceConstants.ATTR_VALUE_ID
                && blackList.contains(difference.getControlNodeDetail().getNode().getNodeName())
                ? RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL
                : RETURN_ACCEPT_DIFFERENCE;
    }

    @Override
    public void skippedComparison(Node node, Node node1) {
    }
}
