package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class SignsVO extends BasicDBObject {

    /**
     *
     */
    private ObjectId _id;
    /**
     *
     */
    private String openid;
    /**
     *
     */
    private String newid;
    /**
     *
     */
    private Date time;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNewid() {
        return newid;
    }

    public void setNewid(String newid) {
        this.newid = newid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object put(String key, Object v){
        if (key.equals("openid")) openid = (String) v;
        else if(key.equals("newid")) newid = (String) v;
        else if(key.equals("time")) time = (Date) v;
        else if(key.equals("_id")) _id = (ObjectId) v;
        return super.put(key,v);
    }
}
