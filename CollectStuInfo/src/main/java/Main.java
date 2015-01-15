import business.GetStuInfo;
import dataAccess.dao.ClassInfo;
import dataAccess.po.ClassinfoPO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by ML3426 on 2015/1/13 0013.
 *
 * @author ML3426
 */
public class Main {
    Logger logger = Logger.getLogger(this.getClass());

    public Main() {
//        PropertyConfigurator.configure("CollectStuInfo/target/classes/log4j.properties");
//        logger.warn("haha");
    }

    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();
        GetStuInfo getStuInfo = new GetStuInfo();
        List<ClassinfoPO> list = classInfo.query();
        for (ClassinfoPO classinfoPO : list) {
            getStuInfo.parseHtml(classinfoPO.getClassId());
            System.out.println(classinfoPO.getId());
        }
    }
}
