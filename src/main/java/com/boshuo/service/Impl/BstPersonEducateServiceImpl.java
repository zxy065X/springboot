package com.boshuo.service.Impl;

import com.boshuo.dao.educate.BstPersonEducateDao;
import com.boshuo.entity.pojo.BstPersonEducateEntity;
import com.boshuo.service.BstPersonEducateService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("bstPersonEducateService")
public class BstPersonEducateServiceImpl extends ServiceImpl<BstPersonEducateDao, BstPersonEducateEntity> implements BstPersonEducateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstPersonEducateEntity> page = this.page(
                new Query<BstPersonEducateEntity>().getPage(params),
                new QueryWrapper<BstPersonEducateEntity>()
        );

        return new PageUtils(page);
    }

}