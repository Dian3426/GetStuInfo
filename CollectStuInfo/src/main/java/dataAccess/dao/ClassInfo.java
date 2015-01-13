package dataAccess.dao;

import dataAccess.HibernateSessionFactory;
import dataAccess.po.ClassinfoPO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ML3426 on 2015/1/14 0014.
 *
 * @author ML3426
 */
public class ClassInfo {
    HibernateSessionFactory hibernateSessionFactory;
    private Logger logger = Logger.getLogger(this.getClass());
    private Session session;
    private Transaction transaction;

    public ClassInfo() {
        hibernateSessionFactory = new HibernateSessionFactory();
    }

    public void save(String classID, String className) {
        try {
            if (hibernateSessionFactory == null) {
                hibernateSessionFactory = new HibernateSessionFactory();
            }
            session = hibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            ClassinfoPO newClass = new ClassinfoPO();
            newClass.setClassId(classID);
            newClass.setClassName(className);
            newClass.setAddTime(new Timestamp(new Date().getTime()));
            session.save(newClass);
            transaction.commit();
            session.clear();
            logger.info("添加班级" + className + ", " + classID);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }

    public void clear() {
        try {
            if (hibernateSessionFactory == null) {
                hibernateSessionFactory = new HibernateSessionFactory();
            }
            session = hibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            String sql = "TRUNCATE TABLE classinfo";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }
}
