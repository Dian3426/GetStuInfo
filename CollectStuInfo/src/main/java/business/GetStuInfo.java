package business;

import dataAccess.dao.StuInfo;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by ML3426 on 2015/1/14 0014.
 *
 * @author ML3426
 */

public class GetStuInfo {
    private static String classInfoUrl;
    private static Logger logger = Logger.getLogger(GetStuInfo.class);
    private StuInfo stuInfo = new StuInfo();

    public GetStuInfo() {
        classInfoUrl = Resourse.getString("getstu");
    }

    public void parseHtml(String classID) {
        Document doc = null;
        HttpURLConnection connection;
        try {
            do {
                connection = (HttpURLConnection)
                        new URL("http://csujwc.its.csu.edu.cn/XSXJ/FB_BJXS_rpt.aspx?Sel_BJ=" + classID).openConnection();
            } while (connection.getResponseCode() != 200);
            doc = Jsoup.parse(connection.getInputStream(), "GBK",
                    "http://csujwc.its.csu.edu.cn/XSXJ/FB_BJXS_rpt.aspx?Sel_BJ=" + classID);
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
        assert doc != null;
        Elements elements = doc.select("table[name][bordercolorlight]");
        for (Element element : elements) {
            Elements rows = element.getElementsByTag("tr");
            rows.remove(0);
            for (Element row : rows) {
                Elements cell = row.getElementsByTag("td");
                stuInfo.save(
                        cell.get(0).text().trim(),
                        cell.get(1).text().trim(),
                        cell.get(2).text().trim(),
                        cell.get(3).text().trim(),
                        cell.get(4).text().trim(),
                        cell.get(5).text().trim(),
                        cell.get(6).text().trim(),
                        cell.get(7).text().trim(),
                        cell.get(8).text().trim(),
                        cell.get(9).text().trim(),
                        cell.get(10).text().trim()
                );
            }
        }
    }
}
