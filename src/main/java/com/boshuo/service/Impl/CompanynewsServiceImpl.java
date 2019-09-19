package com.boshuo.service.Impl;

import com.boshuo.dao.companynews.CompanynewsDao;
import com.boshuo.entity.pojo.CompanynewsEntity;
import com.boshuo.service.CompanynewsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("companynewsService")
public class CompanynewsServiceImpl extends ServiceImpl<CompanynewsDao, CompanynewsEntity> implements CompanynewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanynewsEntity> page = this.page(
                new Query<CompanynewsEntity>().getPage(params),
                new QueryWrapper<CompanynewsEntity>()
        );

        return new PageUtils(page);
    }

}