package dataAccess.po;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ML3426 on 2015/1/14 0014.
 */
@Entity
@Table(name = "stuinfo", schema = "", catalog = "csustuinfo")
public class StuinfoPO {
    private int id;
    private String stuId;
    private String name;
    private String sex;
    private Date birthtime;
    private String nativePlace;
    private String nationality;
    private String politicalStatus;
    private String familyAddress;
    private String zipCode;
    private String district;
    private String cetId;
    private String remarks;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StuID", nullable = true, insertable = true, updatable = true, length = 11)
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Sex", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "Birthtime", nullable = true, insertable = true, updatable = true)
    public Date getBirthtime() {
        return birthtime;
    }

    public void setBirthtime(Date birthtime) {
        this.birthtime = birthtime;
    }

    @Basic
    @Column(name = "NativePlace", nullable = true, insertable = true, updatable = true, length = 255)
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Basic
    @Column(name = "Nationality", nullable = true, insertable = true, updatable = true, length = 255)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "PoliticalStatus", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    @Basic
    @Column(name = "FamilyAddress", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    @Basic
    @Column(name = "ZipCode", nullable = true, insertable = true, updatable = true, length = 255)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "District", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "CetID", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCetId() {
        return cetId;
    }

    public void setCetId(String cetId) {
        this.cetId = cetId;
    }

    @Basic
    @Column(name = "Remarks", nullable = true, insertable = true, updatable = true, length = 255)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuinfoPO stuinfoPO = (StuinfoPO) o;

        if (id != stuinfoPO.id) return false;
        if (birthtime != null ? !birthtime.equals(stuinfoPO.birthtime) : stuinfoPO.birthtime != null) return false;
        if (cetId != null ? !cetId.equals(stuinfoPO.cetId) : stuinfoPO.cetId != null) return false;
        if (district != null ? !district.equals(stuinfoPO.district) : stuinfoPO.district != null) return false;
        if (familyAddress != null ? !familyAddress.equals(stuinfoPO.familyAddress) : stuinfoPO.familyAddress != null)
            return false;
        if (name != null ? !name.equals(stuinfoPO.name) : stuinfoPO.name != null) return false;
        if (nationality != null ? !nationality.equals(stuinfoPO.nationality) : stuinfoPO.nationality != null)
            return false;
        if (nativePlace != null ? !nativePlace.equals(stuinfoPO.nativePlace) : stuinfoPO.nativePlace != null)
            return false;
        if (politicalStatus != null ? !politicalStatus.equals(stuinfoPO.politicalStatus) : stuinfoPO.politicalStatus != null)
            return false;
        if (remarks != null ? !remarks.equals(stuinfoPO.remarks) : stuinfoPO.remarks != null) return false;
        if (sex != null ? !sex.equals(stuinfoPO.sex) : stuinfoPO.sex != null) return false;
        if (stuId != null ? !stuId.equals(stuinfoPO.stuId) : stuinfoPO.stuId != null) return false;
        if (zipCode != null ? !zipCode.equals(stuinfoPO.zipCode) : stuinfoPO.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthtime != null ? birthtime.hashCode() : 0);
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (politicalStatus != null ? politicalStatus.hashCode() : 0);
        result = 31 * result + (familyAddress != null ? familyAddress.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (cetId != null ? cetId.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
