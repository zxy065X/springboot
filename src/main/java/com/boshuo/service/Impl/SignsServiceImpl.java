package com.boshuo.service.Impl;

import com.boshuo.dao.signs.SignsDao;
import com.boshuo.entity.pojo.SignsEntity;
import com.boshuo.service.SignsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("signsService")
public class SignsServiceImpl extends ServiceImpl<SignsDao, SignsEntity> implements SignsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SignsEntity> page = this.page(
                new Query<SignsEntity>().getPage(params),
                new QueryWrapper<SignsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insert(SignsEntity entity) {
        this.insert(entity);
    }

}