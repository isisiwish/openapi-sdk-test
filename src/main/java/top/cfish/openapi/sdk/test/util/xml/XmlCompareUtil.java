package top.cfish.openapi.sdk.test.util.xml;

import lombok.extern.slf4j.Slf4j;
import org.custommonkey.xmlunit.*;
import org.testng.Assert;
import org.w3c.dom.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static sun.nio.ch.IOStatus.EOF;

/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 17:14
 */
@Slf4j
public class XmlCompareUtil
{
    static class IgnoreNamedElementsDifferenceListener implements DifferenceListener
    {
        private Set<String> ignoreElements = new HashSet<String>();
        
        @Override
        public int differenceFound(Difference difference)
        {
            if (difference.getId() == DifferenceConstants.CDATA_VALUE_ID || difference.getId() == DifferenceConstants.TEXT_VALUE_ID)
            {
                String nodeName = difference.getControlNodeDetail().getNode().getParentNode().getNodeName();
                if (ignoreElements.contains(nodeName))
                {
                    log.debug("ignoring element " + nodeName);
                    return DifferenceListener.RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL;
                }
            }
            log.info("Difference found: " + difference.getDescription());
            log.info("           XPath: " + difference.getControlNodeDetail().getXpathLocation());
            
            return DifferenceListener.RETURN_ACCEPT_DIFFERENCE;
        }
        
        @Override
        public void skippedComparison(Node node, Node node1)
        {
        }
        
        public void addIgnoreNode(String... nodeNames)
        {
            for (String att : nodeNames)
            {
                ignoreElements.add(att);
            }
        }
    }
    
    // 便于于xml文件比较
    public static String readFile(String filePath) throws Exception
    {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        if (null == inputStream)
        {
            return null;
        }
        InputStreamReader in = new InputStreamReader(inputStream);
        StringBuilder sb = new StringBuilder();
        
        int c;
        while ((c = in.read()) != EOF)
        {
            sb.append((char)c);
        }
        in.close();
        return sb.toString();
    }
    
    public static boolean compare(String xmlSource, String xmlCompareWith) throws Exception
    {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);
        XMLUnit.setNormalizeWhitespace(true);
        
        IgnoreNamedElementsDifferenceListener diffListener = new IgnoreNamedElementsDifferenceListener();
        diffListener.addIgnoreNode("time");
    
        Diff diff = new Diff(xmlSource, xmlCompareWith);
        diff.overrideDifferenceListener(diffListener);
        return diff.similar();
    }
}
