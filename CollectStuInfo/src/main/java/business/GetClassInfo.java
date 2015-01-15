package business;

import dataAccess.dao.ClassInfo;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by ML3426 on 2015/1/14 0014.
 *
 * @author ML3426
 */
public class GetClassInfo {
    private String classInfoUrl;
    private ClassInfo classInfo = new ClassInfo();
    private Logger logger = Logger.getLogger(this.getClass());

    public GetClassInfo() {
        classInfoUrl = Resourse.getString("getclass");
    }

    public void parseHTML() {
        Document doc;
        try {
            doc = Jsoup.connect(classInfoUrl).
                    timeout(20000).
                    get();
            doc = Jsoup.parse(
                    doc.getElementsByTag("script").
                            get(0).
                            toString().
                            replace("<script language=\"javascript\">parent.theBJ.innerHTML='", "").
                            replace("</script>", "")
            );
            Elements elements = doc.getElementsByTag("option");
            elements.remove(0);
            classInfo.clear();
            for (Element element : elements) {
                classInfo.save(element.attr("value"), element.text());
            }
        } catch (IOException e) {
            if (e instanceof UnknownHostException) {
                JOptionPane.showMessageDialog(
                        null, "无法连接到网络，请查看网络连接是否正常", "Ohh!, Error!", JOptionPane.ERROR_MESSAGE);
            } else if (e instanceof SocketTimeoutException) {
                JOptionPane.showMessageDialog(
                        null, "读取信息超时，请查看网络连接是否正常", "Ohh!, Error!", JOptionPane.ERROR_MESSAGE);
            }
            logger.error(e.getMessage(), e);
        }
    }
}
