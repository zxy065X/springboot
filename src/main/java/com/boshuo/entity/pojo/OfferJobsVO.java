package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class OfferJobsVO extends BasicDBObject {

    private ObjectId id;
    /**
     * 浼佷笟id
     */
    private List<String> companies;
    /**
     * 鑱屼綅鍚嶇О
     */
    private String name;
    /**
     * 浠锋牸
     */
    private String price;
    /**
     * 鑱屼綅浠嬬粛
     */
    private String description;
    /**
     * 闇€姹傞噺
     */
    private Integer postioncount;
    /**
     *
     */
    private Integer companycount;
    /**
     *
     */
    private Integer deliverycount;
    /**
     *
     */
    private Date createtime;
    /**
     *
     */
    private Date updatetime;
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

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPostioncount() {
        return postioncount;
    }

    public void setPostioncount(Integer postioncount) {
        this.postioncount = postioncount;
    }

    public Integer getCompanycount() {
        return companycount;
    }

    public void setCompanycount(Integer companycount) {
        this.companycount = companycount;
    }

    public Integer getDeliverycount() {
        return deliverycount;
    }

    public void setDeliverycount(Integer deliverycount) {
        this.deliverycount = deliverycount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("companies")) companies = (List<String>) v;
        else if (key.equals("name"))name = (String) v;
        else if (key.equals("price")) price = (String) v;
        else if (key.equals("description")) description = (String) v;
        else if (key.equals("company")) name = (String) v;
        else if (key.equals("positionCount")) postioncount = (Integer) v;
        else if (key.equals("companyCount")) companycount = (Integer) v;
        else if (key.equals("deliveryCount")) deliverycount = (Integer) v;
        else if (key.equals("date")) createtime = (Date) v;
        else if (key.equals("updateDate")) updatetime  = (Date) v;
        return super.put(key,v);
    }
}
