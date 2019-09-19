package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class SuggestsVO extends BasicDBObject {

    private ObjectId id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Object offerjob;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private Date date;
    /**
     *
     */
    private Date time;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOfferjob() {
        return offerjob;
    }

    public void setOfferjob(Object offerjob) {
        this.offerjob = offerjob;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("offerJob")) offerjob = v;
        else if (key.equals("name")) name = (String) v;
        else if (key.equals("status")) status = (Integer) v;
        else if (key.equals("date")) date = (Date) v;
        return super.put(key,v);

    }
}
