package com.boshuo.service.Impl;

import com.boshuo.dao.qz.QzXlxxDao;
import com.boshuo.entity.pojo.QzXlxxEntity;
import com.boshuo.service.QzXlxxService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qzXlxxService")
public class QzXlxxServiceImpl extends ServiceImpl<QzXlxxDao, QzXlxxEntity> implements QzXlxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QzXlxxEntity> page = this.page(
                new Query<QzXlxxEntity>().getPage(params),
                new QueryWrapper<QzXlxxEntity>()
        );

        return new PageUtils(page);
    }

}