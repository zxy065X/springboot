package com.boshuo.service.Impl;

import com.boshuo.dao.company.BstCompanyAccountDao;
import com.boshuo.entity.pojo.BstCompanyAccountEntity;
import com.boshuo.entity.pojo.CompaniesEntity;
import com.boshuo.service.BstCompanyAccountService;
import com.boshuo.service.CompaniesService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("bstCompanyAccountService")
public class BstCompanyAccountServiceImpl extends ServiceImpl<BstCompanyAccountDao, BstCompanyAccountEntity> implements BstCompanyAccountService {

    @Autowired
    CompaniesService companiesService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstCompanyAccountEntity> page = this.page(
                new Query<BstCompanyAccountEntity>().getPage(params),
                new QueryWrapper<BstCompanyAccountEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertEntity() {

        //select to mysql
        List<CompaniesEntity> list = companiesService.list();
        for (CompaniesEntity entity:list) {

        }

    }

}