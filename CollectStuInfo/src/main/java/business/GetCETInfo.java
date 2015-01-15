package business;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;

/**
 * Created by ML3426 on 2015/1/14 0014.
 *
 * @author ML3426
 */
public class GetCETInfo {
    private static String classInfoUrl;
    private static Logger logger = Logger.getLogger(GetCETInfo.class);
    private static String grade4;
    private static String grade6;
    private static String submit = "%C8%B7+%B6%A8";

    static {
        classInfoUrl = Resourse.getString("getcet");
        try {
            grade4 = URLEncoder.encode("四级", "GBK");
            grade6 = URLEncoder.encode("六级", "GBK");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String getCETID(String stuID, String stuName) {
        String id = "";
        try {
            Document doc =
                    Jsoup.connect(
                            "http://202.197.61.241/cetmodifyb.asp?username='学号'&password='姓名'&bmlb='类别'&Submit='确认'"
                                    .replace("'学号'", stuID).replace("'姓名'", URLEncoder.encode(stuName, "GBK"))
                                    .replace("'类别'", grade4).replace("'确认'", submit)
                    ).get();
            if (doc.toString().contains("报名、缴费已经成功！")) {
                id = doc.getElementById("zkz").attr("value");
            } else {
                doc =
                        Jsoup.connect(
                                "http://202.197.61.241/cetmodifyb.asp?username='学号'&password='姓名'&bmlb='类别'&Submit='确认'"
                                        .replace("'学号'", stuID).replace("'姓名'", URLEncoder.encode(stuName, "GBK"))
                                        .replace("'类别'", grade6).replace("'确认'", submit)
                        ).get();
                if (doc.toString().contains("报名、缴费已经成功！")) {
                    id = doc.getElementById("zkz").attr("value");
                }
            }
        } catch (IOException e) {
            if (e instanceof UnknownHostException) {
                JOptionPane.showMessageDialog(
                        null, "无法连接到学校四六级查询系统，请查看网络连接是否正常或是否被封", "Ohh!, Error!", JOptionPane.ERROR_MESSAGE);
            }
            logger.error(e.getMessage(), e);
        }
        return id;
    }
}
