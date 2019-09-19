package com.boshuo.service.Impl;

import com.boshuo.dao.companyrecords.CompanyrecordsDao;
import com.boshuo.entity.pojo.CompanyrecordsEntity;
import com.boshuo.service.CompanyrecordsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("companyrecordsService")
public class CompanyrecordsServiceImpl extends ServiceImpl<CompanyrecordsDao, CompanyrecordsEntity> implements CompanyrecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyrecordsEntity> page = this.page(
                new Query<CompanyrecordsEntity>().getPage(params),
                new QueryWrapper<CompanyrecordsEntity>()
        );

        return new PageUtils(page);
    }

}