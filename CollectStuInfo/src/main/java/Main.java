import business.GetClassInfo;
import org.apache.log4j.Logger;

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
        System.out.println(new GetClassInfo().parseHTML());
    }
}