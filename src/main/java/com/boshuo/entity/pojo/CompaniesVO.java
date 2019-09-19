package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class CompaniesVO extends BasicDBObject {

    /**
     *
     */
    private ObjectId id;
    /**
     * 浼佷笟鍚嶇О
     */
    private String comname;
    /**
     * 浼佷笟閭
     */
    private String comemail;
    /**
     * 浼佷笟鍦板潃
     */
    private String comaddress;
    /**
     * 鑱旂郴浜?
     */
    private String comcontact;
    /**
     * 鑱旂郴鏂瑰紡
     */
    private String comphone;
    /**
     * 浼佷笟绠€浠?
     */
    private String comintroduction;
    /**
     * 浼佷笟缃戠珯
     */
    private String comwebsite;
    /**
     * 鎷涜仒鑱屼綅
     */
    private List<String> compositions;
    /**
     * 婵″倹鐏夐弰顖炴敘閸烆喕姹夐崨姗€鍊嬬拠椋庢畱鐏忚鲸婀佹潻娆庨嚋id
     */
    private String accountid;

    private String sourcetype;

    private Integer positioncount;
    /**
     * 浼佷笟logo
     */
    private String comlogo;
    /**
     * 浼佷笟banner鍥?
     */
    private List<String> comimg;
    /**
     *
     */
    private Date updatetime;
    /**
     * 鑱屼綅id
     */
    private Date createtime;
    /**
     *
     */
    private Date tiem;
    /**
     *
     */
    private Integer deleteflag;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComemail() {
        return comemail;
    }

    public void setComemail(String comemail) {
        this.comemail = comemail;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    public String getComcontact() {
        return comcontact;
    }

    public void setComcontact(String comcontact) {
        this.comcontact = comcontact;
    }

    public String getComphone() {
        return comphone;
    }

    public void setComphone(String comphone) {
        this.comphone = comphone;
    }

    public String getComintroduction() {
        return comintroduction;
    }

    public void setComintroduction(String comintroduction) {
        this.comintroduction = comintroduction;
    }

    public String getComwebsite() {
        return comwebsite;
    }

    public void setComwebsite(String comwebsite) {
        this.comwebsite = comwebsite;
    }

    public List<String> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<String> compositions) {
        this.compositions = compositions;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype;
    }

    public Integer getPositioncount() {
        return positioncount;
    }

    public void setPositioncount(Integer positioncount) {
        this.positioncount = positioncount;
    }

    public String getComlogo() {
        return comlogo;
    }

    public void setComlogo(String comlogo) {
        this.comlogo = comlogo;
    }

    public List<String> getComimg() {
        return comimg;
    }

    public void setComimg(List<String> comimg) {
        this.comimg = comimg;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getTiem() {
        return tiem;
    }

    public void setTiem(Date tiem) {
        this.tiem = tiem;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("createdAt")) createtime = (Date) v;
        else if(key.equals("updatedAt")) updatetime = (Date) v;
        else if (key.equals("imgs")) comimg = (List<String>) v;
        else if(key.equals("name")) comname = (String) v;
        else if (key.equals("email")) comemail = (String) v;
        else if(key.equals("address")) comaddress = (String) v;
        else if(key.equals("contact")) comcontact = (String) v;
        else if (key.equals("phoneNumber")) comphone = (String) v;
        else if (key.equals("introduction")) comintroduction = (String) v;
        else if (key.equals("website")) comwebsite = (String) v;
        else if (key.equals("sourceType")) sourcetype = (String) v;
        else if (key.equals("sourceUserId")) accountid = (String) v;
        else if (key.equals("positionCount")) positioncount = (Integer) v;
        else if (key.equals("positions")) compositions = (List<String>) v;
        return super.put(key,v);
    }
}
