package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class CompanyNewsVO extends BasicDBObject {

    /**
     *
     */
    private ObjectId id;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 地址
     */
    private String address;
    /**
     * 规模
     */
    private Integer scope;
    /**
     *
     */
    private Integer status;
    /**
     * 绠€绉?
     */
    private String subtitle;
    /**
     * 寮€濮嬫椂闂?
     */
    private Date starttime;
    /**
     * 缁撴潫鏃堕棿
     */
    private Date endtime;
    /**
     * 方式  1 专场  2 综合  3 合作
     */
    private String kind;
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
    private Integer deleteflag;

    public Object put(String key,Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("title")) title = (String) v;
        else if (key.equals("introduction")) introduction = (String) v;
        else if (key.equals("address")) address = (String) v;
        else if (key.equals("scope")) scope = (Integer) v;
        else if (key.equals("status")) status = (Integer) v;
        else if (key.equals("subTitle")) subtitle= (String) v;
        else if (key.equals("date")) starttime = (Date) v;
        else if (key.equals("endDate")) endtime = (Date) v;
        else if (key.equals("kind")) kind = (String) v;
        return super.put(key,v);
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }
}
