package dataAccess.dao;

import business.GetCETInfo;
import dataAccess.HibernateSessionFactory;
import dataAccess.po.StuinfoPO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by ML3426 on 2015/1/14 0014.
 *
 * @author ML3426
 */
public class StuInfo {
    HibernateSessionFactory hibernateSessionFactory;
    private Logger logger = Logger.getLogger(this.getClass());
    private Session session;
    private Transaction transaction;

    public StuInfo() {
        hibernateSessionFactory = new HibernateSessionFactory();
    }

    public void save(String stuID, String name, String sex, String birthTime, String nativePlace, String nationality,
                     String politicalStatus, String familyAddress, String zipCode, String district, String remark) {
        try {
            if (hibernateSessionFactory == null) {
                hibernateSessionFactory = new HibernateSessionFactory();
            }
            session = hibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            StuinfoPO newStu = new StuinfoPO();
            newStu.setStuId(stuID);
            newStu.setName(name);
            newStu.setSex(sex);
            newStu.setBirthtime(birthTime);
            newStu.setNativePlace(nativePlace);
            newStu.setNationality(nationality);
            newStu.setPoliticalStatus(politicalStatus);
            newStu.setFamilyAddress(familyAddress);
            newStu.setZipCode(zipCode);
            newStu.setDistrict(district);
            newStu.setRemarks(remark);
            newStu.setCetId(GetCETInfo.getCETID(stuID, name));
            session.save(newStu);
            logger.info("添加学生 " + name + ", " + stuID);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        } finally {
            transaction.commit();
            session.clear();
        }
    }
}
