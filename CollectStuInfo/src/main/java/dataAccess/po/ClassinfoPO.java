package dataAccess.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ML3426 on 2015/1/14 0014.
 */
@Entity
@Table(name = "classinfo", schema = "", catalog = "csustuinfo")
public class ClassinfoPO {
    private int id;
    private String classId;
    private String className;
    private Timestamp addTime;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ClassID", nullable = true, insertable = true, updatable = true, length = 11)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "ClassName", nullable = true, insertable = true, updatable = true, length = 255)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "AddTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassinfoPO that = (ClassinfoPO) o;

        if (id != that.id) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        return result;
    }
}
