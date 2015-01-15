package business;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ML3426 on 2015/1/14 0014.
 *
 * @author ML3426
 */
public class Resourse {
    private static SAXReader reader = new SAXReader();
    private static Document document = null;
    private static Logger logger = Logger.getLogger(Resourse.class);

    private static void parse() {
        try {
            document = reader.read(new File("CollectStuInfo/target/classes/string.xml"));
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static Map<String, String> getString() {
        if (document == null) {
            parse();
        }
        Element rootElement = document.getRootElement();
        Element sourceElement = rootElement.element("collectStuInfo").element("source");
        Map<String, String> map = new HashMap<>();
        for (Iterator it = sourceElement.elementIterator(); it.hasNext(); ) {
            Element stringElement = (Element) it.next();
            map.put(stringElement.attributeValue("type"), stringElement.getText());
        }
        return map;
    }

    public static String getString(String name) {
        return getString().get(name);
    }

    public static String getCClass() {
        if (document == null) {
            parse();
        }
        Element rootElement = document.getRootElement();
        Element sourceElement = rootElement.element("collectStuInfo").element("current");
        for (Iterator it = sourceElement.elementIterator(); it.hasNext(); ) {
            Element stringElement = (Element) it.next();
            if (stringElement.attributeValue("type").equals("class")) {
                return stringElement.getText();
            }
        }
        return "";
    }

    public static void setCClass(String cClass) {
        if (document == null) {
            parse();
        }
        Element rootElement = document.getRootElement();
        Element sourceElement = rootElement.element("collectStuInfo").element("current");
        for (Iterator it = sourceElement.elementIterator(); it.hasNext(); ) {
            Element stringElement = (Element) it.next();
            if (stringElement.attributeValue("type").equals("class")) {
                stringElement.setText(cClass);
            }
        }
        try {
            XMLWriter writer = new XMLWriter(new FileWriter(new File("CollectStuInfo/target/classes/string.xml")));
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String getCStu() {
        if (document == null) {
            parse();
        }
        Element rootElement = document.getRootElement();
        Element sourceElement = rootElement.element("collectStuInfo").element("current");
        for (Iterator it = sourceElement.elementIterator(); it.hasNext(); ) {
            Element stringElement = (Element) it.next();
            if (stringElement.attributeValue("type").equals("student")) {
                return stringElement.getText();
            }
        }
        return "";
    }

    public static void setCStu(String cStu) {
        if (document == null) {
            parse();
        }
        Element rootElement = document.getRootElement();
        Element sourceElement = rootElement.element("collectStuInfo").element("current");
        for (Iterator it = sourceElement.elementIterator(); it.hasNext(); ) {
            Element stringElement = (Element) it.next();
            if (stringElement.attributeValue("type").equals("student")) {
                stringElement.setText(cStu);
            }
        }
        updateXml();
    }

    private static void updateXml() {
        try {
            XMLWriter writer = new XMLWriter(new FileWriter(new File("CollectStuInfo/target/classes/string.xml")));
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
