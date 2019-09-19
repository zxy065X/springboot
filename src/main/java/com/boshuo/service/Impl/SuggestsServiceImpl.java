package com.boshuo.service.Impl;

import com.boshuo.dao.suggests.SuggestsDao;
import com.boshuo.entity.pojo.SuggestsEntity;
import com.boshuo.service.SuggestsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("suggestsService")
public class SuggestsServiceImpl extends ServiceImpl<SuggestsDao, SuggestsEntity> implements SuggestsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuggestsEntity> page = this.page(
                new Query<SuggestsEntity>().getPage(params),
                new QueryWrapper<SuggestsEntity>()
        );

        return new PageUtils(page);
    }

}