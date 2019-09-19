package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class CompanyTicketsVO extends BasicDBObject {


    private ObjectId id;
    /**
     *
     */
    private String openid;
    /**
     * 娴兼俺顔唅d
     */
    private String newsid;
    /**
     * 会讯标题
     */
    private String title;
    /**
     * 浼佷笟鎶ュ悕浜烘樀绉?
     */
    private String nickname;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 企业名称
     */
    private String company;
    /**
     * 企业邮箱
     */
    private String email;
    /**
     * 身份证号码
     */
    private String idcard;
    /**
     *
     */
    private Date time;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("openid")) openid = (String) v;
        else if(key.equals("newsid")) newsid = (String) v;
        else if (key.equals("title")) title = (String) v;
        else if (key.equals("nickName")) nickname = (String) v;
        else if (key.equals("name")) name = (String) v;
        else if (key.equals("phone")) phone = (String) v;
        else if (key.equals("company")) company = (String) v;
        else if (key.equals("email")) email = (String) v;
        else if (key.equals("idcard")) idcard = (String) v;
        else if (key.equals("time")) time = (Date) v;
        return super.put(key,v);
    }
}
