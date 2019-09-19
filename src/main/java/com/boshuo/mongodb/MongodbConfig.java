package com.boshuo.mongodb;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import com.boshuo.dao.accountinfo.AccountInfoDao;
import com.boshuo.dao.companies.CompaniesDao;
import com.boshuo.dao.companynews.CompanynewsDao;
import com.boshuo.dao.companyrecords.CompanyrecordsDao;
import com.boshuo.dao.companytickets.CompanyTicketsDao;
import com.boshuo.dao.offerjobs.OfferJobsDao;
import com.boshuo.dao.qz.QzGrjbxxDao;
import com.boshuo.dao.qz.QzGzjlDao;
import com.boshuo.dao.qz.QzXlxxDao;
import com.boshuo.dao.signs.SignsDao;
import com.boshuo.dao.suggests.SuggestsDao;
import com.boshuo.dao.wxsigns.WxsignsDao;
import com.boshuo.entity.pojo.*;
import com.boshuo.service.SignsService;
import com.boshuo.util.DateUtils;
import com.boshuo.util.MongodbUtils;
import com.boshuo.util.StringUitl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MongodbConfig implements MongoDBService {


    @Autowired
    SignsService signsService;

    @Autowired
    SignsDao signsDao;

    @Autowired
    AccountInfoDao accountInfoDao;

    @Autowired
    CompaniesDao companiesDao;

    @Autowired
    CompanynewsDao companynewsDao;

    @Autowired
    CompanyTicketsDao companyTicketsDao;

    @Autowired
    OfferJobsDao offerJobsDao;

    @Autowired
    SuggestsDao suggestsDao;

    @Autowired
    WxsignsDao wxsignsDao;

    @Autowired
    QzGrjbxxDao qzGrjbxxDao;

    @Autowired
    QzXlxxDao qzXlxxDao;

    @Autowired
    QzGzjlDao qzGzjlDao;

    @Autowired
    CompanyrecordsDao companyrecordsDao;

    public static class MongodbHandle {
        public static Mongo mongo = new MongoClient("116.62.152.242", 27017);
    }

    private static Mongo getmongo() {
        return MongodbUtils.MongodbHandle.mongo;
    }

    @Override
    public void test() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("signs");

        collection.setObjectClass(SignsVO.class);

        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("time", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        int i = 0;
        while (dbObjects.hasNext()) {
            SignsVO entity = (SignsVO) dbObjects.next();
            SignsEntity signsEntity = new SignsEntity();
            signsEntity.set_id(entity.get_id().toString());
            signsEntity.setOpenid(entity.getOpenid());
            signsEntity.setNewid(entity.getNewid());
            signsEntity.setTime(entity.getTime());
//            signsDao.insert(signsEntity);
            System.out.println(entity);
            i++;
        }
        System.out.println(i);
    }

    @Override
    public void accountInfo() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("users");
        collection.setObjectClass(AccountInfoVO.class);


        //添加条件，用前一天的起止时间做条件，由于mongondb中，管理员表没有时间字段，暂不加条件查询
        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("time", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find();
        while (dbObjects.hasNext()) {
            AccountInfoVO entity = (AccountInfoVO) dbObjects.next();

            AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
            accountInfoEntity.setId(entity.getId().toString());
            accountInfoEntity.setCreatetime(new Date());
            accountInfoEntity.setEmail(entity.getEmail());
            accountInfoEntity.setHeadimg(entity.getHeadImg());
            accountInfoEntity.setInfo(entity.getInfo());
            accountInfoEntity.setLevel(entity.getLevel());
            accountInfoEntity.setLoginname(entity.getLoginName());
            accountInfoEntity.setName(entity.getName());
            accountInfoEntity.setPassword(entity.getPassword());
            accountInfoEntity.setPhone(entity.getPhone());
            accountInfoEntity.setPosition(entity.getPosition());
            accountInfoDao.insert(accountInfoEntity);
        }
    }

    @Override
    public void companies() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("companies");
        collection.setObjectClass(CompaniesVO.class);

        //企业表理由有两个时间字段，统一用创建时间做条件
        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("createdAt", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            CompaniesVO vo = (CompaniesVO) dbObjects.next();
            CompaniesEntity entity = new CompaniesEntity();
            entity.setId(vo.getId().toString());
            entity.setTiem(new Date());
            entity.setCreatetime(vo.getCreatetime());
            entity.setAccountid(vo.getAccountid());
            entity.setComaddress(vo.getComaddress());
            entity.setComcontact(vo.getComcontact());
            entity.setComemail(vo.getComemail());
            entity.setComimg(StringUitl.list2String(vo.getComimg(), ","));
            entity.setComintroduction(vo.getComintroduction());
            entity.setComlogo(vo.getComlogo());
            entity.setComname(vo.getComname());
            entity.setComphone(vo.getComphone());
            entity.setCompositions(StringUitl.list2String(vo.getCompositions(), ","));
            entity.setComwebsite(vo.getComwebsite());
            entity.setDeleteflag(0);
            entity.setPositioncount(vo.getPositioncount());
            entity.setSourcetype(vo.getSourcetype());
            entity.setUpdatetime(vo.getUpdatetime());
            companiesDao.insert(entity);
        }
    }

    @Override
    public void companynews() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("companynews");
        collection.setObjectClass(CompanyNewsVO.class);

        //会讯只有开始时间和结束时间，统一取开始时间
        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("date", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            CompanyNewsVO vo = (CompanyNewsVO) dbObjects.next();
            CompanynewsEntity entity = new CompanynewsEntity();
            entity.setId(vo.getId().toString());
            entity.setAddress(vo.getAddress());
            entity.setIntroduction(vo.getIntroduction());
            entity.setKind(vo.getKind());
            entity.setScope(vo.getScope());
            entity.setStatus(vo.getStatus());
            entity.setTitle(vo.getTitle());
            entity.setCreatetime(new Date());
            entity.setDeleteflag(0);
            entity.setUpdatetime(new Date());
            entity.setEndtime(vo.getEndtime());
            entity.setStarttime(vo.getStarttime());
            entity.setSubtitle(vo.getSubtitle());
            companynewsDao.insert(entity);
        }
    }

    @Override
    public void companytickets() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("companytickets");
        collection.setObjectClass(CompanyTicketsVO.class);


        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("time", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            CompanyTicketsVO vo = (CompanyTicketsVO) dbObjects.next();
            CompanyTicketsEntity entity = new CompanyTicketsEntity();
            entity.setId(vo.getId().toString());
            entity.setCompany(vo.getCompany());
            entity.setCreatetime(new Date());
            entity.setEmail(vo.getEmail());
            entity.setIdcard(vo.getIdcard());
            entity.setName(vo.getName());
            entity.setNewsid(vo.getNewsid());
            entity.setNickname(vo.getNickname());
            entity.setOpenid(vo.getOpenid());
            entity.setPhone(vo.getPhone());
            entity.setTitle(vo.getTitle());
            entity.setTime(vo.getTime());
            companyTicketsDao.insert(entity);
        }
    }

    @Override
    public void offerjobs() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("offerjobs");
        collection.setObjectClass(OfferJobsVO.class);

        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("date", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            OfferJobsVO vo = (OfferJobsVO) dbObjects.next();
            OfferJobsEntity entity = new OfferJobsEntity();
            entity.setId(vo.getId().toString());
            List<String> comId = companiesDao.selectIdByName(vo.getCompanies().get(0));
            if (comId.size() == 0) continue;
            entity.setComid(comId.get(0));
            entity.setCompanycount(vo.getCompanycount());
            entity.setCreatetime(vo.getCreatetime());
            entity.setUpdatetime(vo.getUpdatetime());
            entity.setDeliverycount(vo.getDeliverycount());
            entity.setDescription(vo.getDescription());
            entity.setName(vo.getName());
            entity.setPostioncount(vo.getPostioncount());
            entity.setPrice(vo.getPrice());
            entity.setTime(new Date());
            offerJobsDao.insert(entity);
        }
    }

    @Override
    public void suggests() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("suggests");
        collection.setObjectClass(SuggestsVO.class);

        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("date", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            SuggestsVO vo = (SuggestsVO) dbObjects.next();
            String string = vo.getOfferjob().toString();
            JSONObject object = JSON.parseObject(string);
            String name = object.get("name").toString();
            SuggestsEntity entity = new SuggestsEntity();
            entity.setId(vo.getId().toString());
            entity.setDate(vo.getDate());
            entity.setName(vo.getName());
            entity.setStatus(vo.getStatus());
            entity.setTime(new Date());
            entity.setOfferjob(name);
            suggestsDao.insert(entity);
        }
    }

    @Override
    public void wxsigns() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("wxsigns");
        collection.setObjectClass(WxsignsVO.class);

        //加时间条件，取昨天起始时间
        DBObject query = new BasicDBObject();
        Date begin = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date end = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("time", new BasicDBObject("$gte", begin).append("$lte", end));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            WxsignsVO vo = (WxsignsVO) dbObjects.next();
            if (vo.getStatus() == 2) {
                WxsignsEntity entity = new WxsignsEntity();
                entity.setId(vo.getId().toString());
                entity.setCreatetime(new Date());
                entity.setEmail(vo.getEmail());
                entity.setGender(vo.getGender());
                entity.setGraduated(vo.getGraduated());
                entity.setJob(vo.getJob());
                entity.setMajor(vo.getMajor());
                entity.setName(vo.getName());
                String nickname = StringUitl.filterEmoji(vo.getNickname());
                entity.setNickname(nickname);
                entity.setOpenid(vo.getOpenid());
                entity.setPhone(vo.getPhone());
                entity.setSchool(vo.getSchool());
                entity.setStatus(vo.getStatus());
                entity.setTime(vo.getTime());
                entity.setWatch(vo.getWatch());
                entity.setWechat(vo.getWechat());
                wxsignsDao.insert(entity);
            }
        }
    }

    @Override
    public void wechat() {
        DB db = getmongo().getDB("wechat");
        DBCollection collection = db.getCollection("users");
        collection.setObjectClass(WeChatVO.class);

        //加时间条件，取昨天起始时间
        DBObject query = new BasicDBObject();
        Date begins = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date ends = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("createdAt", new BasicDBObject("$gte", begins).append("$lte", ends));

        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()) {
            WeChatVO vo = (WeChatVO) dbObjects.next();
            if (StringUtils.isNotBlank(vo.getOpenid())) {
                String string = vo.getResume().toString();
                JSONObject object = JSON.parseObject(string);
                JSONObject online = object.getJSONObject("online");
                String name = online.getString("name");
                Integer age = online.getInteger("age");
                Integer gender = online.getInteger("gender");
                String idcard = online.getString("idcard");
                String place = online.getString("place");
                String telephone = online.getString("telephone");
                String wechat = online.getString("wechat");
                String email = online.getString("email");
                String workYear = online.getString("workYear");
                String oneWord = online.getString("oneWord");
                QzGrjbxxEntity entity = new QzGrjbxxEntity();
                entity.setId(UUID.randomUUID().toString());
                entity.setAge(age);
                entity.setDeleteflag(0);
                entity.setEmail(email);
                entity.setGender(gender);
                entity.setIdcard(idcard);
                entity.setName(name);
                String s = StringUitl.filterEmoji(oneWord);
                entity.setOneword(s);
                entity.setOpenid(vo.getOpenid());
                entity.setPlace(place);
                entity.setTelephone(telephone);
                entity.setWechat(wechat);
                entity.setWorkyear(workYear);
                qzGrjbxxDao.insert(entity);
                QzXlxxEntity xlxxEntity = new QzXlxxEntity();
                JSONObject education = online.getJSONObject("education");
                String school = education.getString("school");
                String major = education.getString("major");
                String level = education.getString("level");
                JSONObject end = education.getJSONObject("end");
                xlxxEntity.setId(UUID.randomUUID().toString());
                xlxxEntity.setUserid(entity.getId());
                xlxxEntity.setDeleteflag(0);
//                if (StringUtils.isNotBlank(end)) {
//                    xlxxEntity.setEnd(DateUtils.parseSS(end));
//                }
                if (end != null) {
                    Date date = end.getDate("$date");
                    xlxxEntity.setEnd(end.getDate("$date"));
                }
                xlxxEntity.setSchool(school);
                xlxxEntity.setMajor(major);
                xlxxEntity.setLevel(level);
                qzXlxxDao.insert(xlxxEntity);

                JSONArray works = online.getJSONArray("works");
                if (works.size() > 0) {
                    for (int i = 0; i < works.size(); i++) {
                        JSONObject o = (JSONObject) works.get(i);
                        String company = o.getString("company");
                        String job = o.getString("job");
                        String description = o.getString("description");
                        JSONObject begin = o.getJSONObject("begin");
                        JSONObject end1 = o.getJSONObject("end");
                        QzGzjlEntity gzjlEntity = new QzGzjlEntity();
                        gzjlEntity.setId(UUID.randomUUID().toString());
                        gzjlEntity.setUserid(entity.getId());
                        if (begin != null) {
                            gzjlEntity.setBegin(begin.getDate("$date"));
                        }
                        if (end1 != null) {
                            gzjlEntity.setEnd(end1.getDate("$date"));
                        }
                        gzjlEntity.setCompany(company);
                        gzjlEntity.setJob(job);
                        gzjlEntity.setDescription(description);
                        gzjlEntity.setDeleteflag(0);
                        qzGzjlDao.insert(gzjlEntity);
                    }
                }

            }
        }
    }

    @Override
    public void companyrecords() {
        DB db = getmongo().getDB("www");
        DBCollection collection = db.getCollection("companyrecords");
        collection.setObjectClass(CompanyrecordsVO.class);


        //加时间条件，取昨天起始时间
        DBObject query = new BasicDBObject();
        Date begins = DateUtils.getDayStartTime(DateUtils.getBeforeDay(new Date()));
        Date ends = DateUtils.getDayEndTime(DateUtils.getBeforeDay(new Date()));
        query.put("date", new BasicDBObject("$gte", begins).append("$lte", ends));


        DBCursor dbObjects = collection.find(query);
        while (dbObjects.hasNext()){
            CompanyrecordsVO vo = (CompanyrecordsVO) dbObjects.next();
            CompanyrecordsEntity entity = new CompanyrecordsEntity();
            entity.setId(UUID.randomUUID().toString());
            entity.setCompanyid(vo.getCompanyid());
            entity.setNewsid(vo.getNewsid());
            entity.setDate(vo.getDate());
            entity.setCreatetime(new Date());

            companyrecordsDao.insert(entity);
        }
    }

}
