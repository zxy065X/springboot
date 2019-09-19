package com.boshuo.service.Impl;

import com.boshuo.dao.companytickets.CompanyTicketsDao;
import com.boshuo.entity.pojo.CompanyTicketsEntity;
import com.boshuo.service.CompanyTicketsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("companyTicketsService")
public class CompanyTicketsServiceImpl extends ServiceImpl<CompanyTicketsDao, CompanyTicketsEntity> implements CompanyTicketsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyTicketsEntity> page = this.page(
                new Query<CompanyTicketsEntity>().getPage(params),
                new QueryWrapper<CompanyTicketsEntity>()
        );

        return new PageUtils(page);
    }

}