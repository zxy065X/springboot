package com.boshuo.service.Impl;

import com.boshuo.dao.offerjobs.OfferJobsDao;
import com.boshuo.entity.pojo.OfferJobsEntity;
import com.boshuo.service.OfferJobsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("offerJobsService")
public class OfferJobsServiceImpl extends ServiceImpl<OfferJobsDao, OfferJobsEntity> implements OfferJobsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OfferJobsEntity> page = this.page(
                new Query<OfferJobsEntity>().getPage(params),
                new QueryWrapper<OfferJobsEntity>()
        );

        return new PageUtils(page);
    }

}