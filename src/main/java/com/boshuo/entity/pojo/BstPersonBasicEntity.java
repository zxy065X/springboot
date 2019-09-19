package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-16 18:13:55
 */
@Data
@TableName("bst_Person_Basic")
public class BstPersonBasicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.comments
     */
    @TableId
    private Integer mid;
    /**
     * $column.comments
     */
    private Integer perid;
    /**
     * $column.comments
     */
    private String username;
    /**
     * $column.comments
     */
    private String realname;
    /**
     * $column.comments
     */
    private String enrealname;
    /**
     * $column.comments
     */
    private Boolean sex;
    /**
     * $column.comments
     */
    private Integer marriage;
    /**
     * $column.comments
     */
    private Date birthdate;
    /**
     * $column.comments
     */
    private String stature;
    /**
     * $column.comments
     */
    private Integer nation;
    /**
     * $column.comments
     */
    private Integer polity;
    /**
     * $column.comments
     */
    private String country;
    /**
     * $column.comments
     */
    private String encountry;
    /**
     * $column.comments
     */
    private Integer workplacearea;
    /**
     * $column.comments
     */
    private Integer workplacecity;
    /**
     * $column.comments
     */
    private String workplacename;
    /**
     * $column.comments
     */
    private Integer homeplacearea;
    /**
     * $column.comments
     */
    private Integer homeplacecity;
    /**
     * $column.comments
     */
    private String homeplacename;
    /**
     * $column.comments
     */
    private Integer degree;
    /**
     * $column.comments
     */
    private Integer advance;
    /**
     * $column.comments
     */
    private String graduate;
    /**
     * $column.comments
     */
    private Integer idtype;
    /**
     * $column.comments
     */
    private String idcode;
    /**
     * $column.comments
     */
    private Integer contact1;
    /**
     * $column.comments
     */
    private Integer contact2;
    /**
     * $column.comments
     */
    private Integer contact3;
    /**
     * $column.comments
     */
    private String mobile;
    /**
     * $column.comments
     */
    private String phone;
    /**
     * $column.comments
     */
    private String qq;
    /**
     * $column.comments
     */
    private String postcode;
    /**
     * $column.comments
     */
    private String address;
    /**
     * $column.comments
     */
    private String enaddress;
    /**
     * $column.comments
     */
    private String homepage;
    /**
     * $column.comments
     */
    private Integer photoflag;
    /**
     * $column.comments
     */
    private String photourl;
    /**
     * $column.comments
     */
    private Integer photokeep;
    /**
     * $column.comments
     */
    private Integer videoflag;
    /**
     * $column.comments
     */
    private Integer videostate;
    /**
     * $column.comments
     */
    private String videourl;
    /**
     * $column.comments
     */
    private String videophotourl;
    /**
     * $column.comments
     */
    private Date videodate;
    /**
     * $column.comments
     */
    private Integer videodays;
    /**
     * $column.comments
     */
    private Integer showmeflag;
    /**
     * $column.comments
     */
    private Integer showmeid;
    /**
     * $column.comments
     */
    private String showmeads;
    /**
     * $column.comments
     */
    private Date showmedate;
    /**
     * $column.comments
     */
    private Date showmeenddate;
    /**
     * $column.comments
     */
    private Integer bankflag;
    /**
     * $column.comments
     */
    private String bankname;
    /**
     * $column.comments
     */
    private String bankid;
    /**
     * $column.comments
     */
    private String specialty;
    /**
     * $column.comments
     */
    private String specialtyname;
    /**
     * $column.comments
     */
    private String schoolname;

}
