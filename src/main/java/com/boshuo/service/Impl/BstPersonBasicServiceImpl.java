package com.boshuo.service.Impl;

import com.boshuo.dao.person.BstPersonBasicDao;
import com.boshuo.entity.pojo.*;
import com.boshuo.service.*;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import com.boshuo.util.enums.LevelEnums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("bstPersonBasicService")
public class BstPersonBasicServiceImpl extends ServiceImpl<BstPersonBasicDao, BstPersonBasicEntity> implements BstPersonBasicService {

    @Autowired
    QzGrjbxxService qzGrjbxxService;

    @Autowired
    BstPersonBasicDao bstPersonBasicDao;

    @Autowired
    QzGzjlService qzGzjlService;

    @Autowired
    QzXlxxService qzXlxxService;

    @Autowired
    BstPersonItemService bstPersonItemService;

    @Autowired
    BstPersonResumeService bstPersonResumeService;

    @Autowired
    BstPersonEducateService bstPersonEducateService;

    @Autowired
    BstPersonAccountService bstPersonAccountService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstPersonBasicEntity> page = this.page(
                new Query<BstPersonBasicEntity>().getPage(params),
                new QueryWrapper<BstPersonBasicEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int insertEntity() {

        List<QzGrjbxxEntity> list = qzGrjbxxService.list();
        for (QzGrjbxxEntity qzGrjbxxEntity : list) {
            if (StringUtils.isNotBlank(qzGrjbxxEntity.getName())) {
                //通过手机去匹配，系统里面是否已经存在了
                int count = bstPersonBasicDao.queryEntity(qzGrjbxxEntity.getTelephone());
                if (count > 0) continue;


                BstPersonAccountEntity accountEntity = new BstPersonAccountEntity();
                accountEntity.setUsername(qzGrjbxxEntity.getTelephone());
                //截取密码
                String password = qzGrjbxxEntity.getTelephone().substring(7,qzGrjbxxEntity.getTelephone().length());
                accountEntity.setPassword("91bs"+password);
                accountEntity.setEmail(qzGrjbxxEntity.getEmail());
                accountEntity.setLoginnum(0);
                accountEntity.setRegdate(new Date());
                bstPersonAccountService.save(accountEntity);

                BstPersonBasicEntity entity = new BstPersonBasicEntity();
                entity.setPerid(accountEntity.getPerid());
                entity.setUsername(qzGrjbxxEntity.getTelephone());
                entity.setRealname(qzGrjbxxEntity.getName());
                entity.setPhone(qzGrjbxxEntity.getTelephone());
                this.save(entity);

                //简历
                BstPersonResumeEntity resumeEntity = new BstPersonResumeEntity();
                resumeEntity.setPerid(accountEntity.getPerid());
                resumeEntity.setUsername(qzGrjbxxEntity.getName());
                resumeEntity.setResumename("默认简历");
                resumeEntity.setVisitnum(0);
                resumeEntity.setVisitstate(2);
                resumeEntity.setDefaultsign(1);
                resumeEntity.setAppraise(qzGrjbxxEntity.getOneword());
                bstPersonResumeService.save(resumeEntity);

                //工作经历
                List<QzGzjlEntity> gzjlEntities = qzGzjlService.list();
                for (QzGzjlEntity gzjlEntity : gzjlEntities) {
                    BstPersonItemEntity itemEntity = new BstPersonItemEntity();
                    itemEntity.setPerid(accountEntity.getPerid());
                    itemEntity.setUsername(qzGrjbxxEntity.getName());
                    itemEntity.setResid(resumeEntity.getResid());
                    Calendar begin = Calendar.getInstance();
                    begin.setTime(gzjlEntity.getBegin());
                    itemEntity.setBeginyear(begin.get(Calendar.YEAR));
                    itemEntity.setBeginmonth(begin.get(Calendar.MONTH) + 1);
                    Calendar end = Calendar.getInstance();
                    end.setTime(gzjlEntity.getEnd());
                    itemEntity.setEndyear(end.get(Calendar.YEAR));
                    itemEntity.setEndmonth(end.get(Calendar.MONTH) + 1);
                    itemEntity.setBurdendesc(gzjlEntity.getDescription());
                    itemEntity.setState(1);
                    bstPersonItemService.save(itemEntity);
                }

                //教育信息
                List<QzXlxxEntity> xlxxEntities = qzXlxxService.list();
                for (QzXlxxEntity xlxxEntity : xlxxEntities) {
                    BstPersonEducateEntity educateEntity = new BstPersonEducateEntity();
                    educateEntity.setPerid(accountEntity.getPerid());
                    educateEntity.setUsername(qzGrjbxxEntity.getName());
                    educateEntity.setResid(resumeEntity.getResid());
                    Calendar end = Calendar.getInstance();
                    end.setTime(xlxxEntity.getEnd());
                    educateEntity.setEndyear(end.get(Calendar.YEAR));
                    educateEntity.setEndmonth(end.get(Calendar.MONTH)+1);
                    educateEntity.setSchoolname(xlxxEntity.getSchool());
                    educateEntity.setSpecialty(xlxxEntity.getMajor());
                    educateEntity.setDegree(LevelEnums.getTypes(xlxxEntity.getLevel()));
                    educateEntity.setLang(1);
                    bstPersonEducateService.save(educateEntity);
                }

            }
        }

        return 0;
    }

}