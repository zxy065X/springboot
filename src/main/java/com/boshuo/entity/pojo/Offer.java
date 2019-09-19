package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;

public class Offer extends BasicDBObject {

    private String name;

    public Object put(String key,Object v){
        if (key.equals("name")) name = (String) v;
        return super.put(key,v);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
