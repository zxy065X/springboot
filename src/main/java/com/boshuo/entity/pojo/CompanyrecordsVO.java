package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class CompanyrecordsVO extends BasicDBObject {

    private ObjectId id;
    /**
     *
     */
    private String newsid;
    /**
     *
     */
    private String companyid;
    /**
     *
     */
    private Date date;
    /**
     *
     */
    private Date createtime;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("newsId")) newsid = (String) v;
        else if (key.equals("companyId")) companyid = (String) v;
        else if (key.equals("date")) date = (Date) v;
        return super.put(key, v);
    }
}
