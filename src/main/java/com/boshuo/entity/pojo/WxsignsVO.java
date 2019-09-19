package com.boshuo.entity.pojo;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class WxsignsVO extends BasicDBObject {

    private ObjectId id;
    /**
     *
     */
    private String openid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 鏄电О
     */
    private String nickname;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 求职意向
     */
    private String job;
    /**
     * 学校
     */
    private String school;
    /**
     * 专业
     */
    private String major;
    /**
     * 毕业时间
     */
    private String graduated;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 关注职业
     */
    private String watch;
    /**
     * 微信号
     */
    private String wechat;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private Date createtime;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object put(String key, Object v){
        if (key.equals("_id")) id = (ObjectId) v;
        else if (key.equals("openid")) openid = (String) v;
        else if (key.equals("name")) name = (String) v;
        else if (key.equals("phone")) phone = (String) v;
        else if (key.equals("nickName")) nickname = (String) v;
        else if (key.equals("gender")) gender = (Integer) v;
        else if (key.equals("job")) job = (String) v;
        else if (key.equals("school")) school = (String) v;
        else if (key.equals("major")) major = (String) v;
        else if (key.equals("graduated")) graduated = (String) v;
        else if (key.equals("email")) email = (String) v;
        else if (key.equals("watch")) watch = (String) v;
        else if (key.equals("wechat")) wechat = (String) v;
        else if (key.equals("status")) status = (Integer) v;
        else if (key.equals("time")) time = (Date) v;
        return super.put(key, v);
    }
}
