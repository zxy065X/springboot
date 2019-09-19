package com.boshuo.service.Impl;

import com.boshuo.dao.job.BstCompanyJobDao;
import com.boshuo.entity.pojo.BstCompanyJobEntity;
import com.boshuo.service.BstCompanyJobService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("bstCompanyJobService")
public class BstCompanyJobServiceImpl extends ServiceImpl<BstCompanyJobDao, BstCompanyJobEntity> implements BstCompanyJobService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstCompanyJobEntity> page = this.page(
                new Query<BstCompanyJobEntity>().getPage(params),
                new QueryWrapper<BstCompanyJobEntity>()
        );

        return new PageUtils(page);
    }

}