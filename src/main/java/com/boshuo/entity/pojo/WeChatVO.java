package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class WeChatVO extends BasicDBObject {

    private ObjectId id;

    private Object resume;

    private String openid;

    private Date createdAt;

    private Date updatedAt;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Object getResume() {
        return resume;
    }

    public void setResume(Object resume) {
        this.resume = resume;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("resume")) resume = v;
        else if (key.equals("openid")) openid = (String) v;
        else if (key.equals("createdAt")) createdAt = (Date) v;
        else if (key.equals("updatedAt")) updatedAt = (Date) v;
        return super.put(key, v);
    }
}
