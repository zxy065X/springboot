package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class AccountInfoVO extends BasicDBObject {

    /**
     *
     */
    private ObjectId id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 职位
     */
    private String position;
    /**
     * 电话
     */
    private String phone;
    /**
     * 登陆名
     */
    private String loginName;
    /**
     * 简介
     */
    private String info;
    /**
     *
     */
    private Integer level;
    /**
     * 图像
     */
    private String headImg;
    /**
     *
     */
    private Date createTime;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if(key.equals("email")) email = (String) v;
        else if(key.equals("name")) name = (String) v;
        else if(key.equals("password")) password = (String) v;
        else if (key.equals("position")) position = (String) v;
        else if(key.equals("phone")) phone = (String) v;
        else if (key.equals("login_name")) loginName = (String) v;
        else if (key.equals("info")) info = (String) v;
        else if (key.equals("level")) level = (Integer)v;
        else if (key.equals("head_img")) headImg = (String) v;
        return super.put(key,v);
    }

}
