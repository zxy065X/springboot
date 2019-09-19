package com.boshuo.service.Impl;

import com.boshuo.dao.companies.CompaniesDao;
import com.boshuo.entity.pojo.CompaniesEntity;
import com.boshuo.service.CompaniesService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("companiesService")
public class CompaniesServiceImpl extends ServiceImpl<CompaniesDao, CompaniesEntity> implements CompaniesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompaniesEntity> page = this.page(
                new Query<CompaniesEntity>().getPage(params),
                new QueryWrapper<CompaniesEntity>()
        );

        return new PageUtils(page);
    }

}