package com.boshuo.service.Impl;

import com.boshuo.dao.qz.QzGzjlDao;
import com.boshuo.entity.pojo.QzGzjlEntity;
import com.boshuo.service.QzGzjlService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qzGzjlService")
public class QzGzjlServiceImpl extends ServiceImpl<QzGzjlDao, QzGzjlEntity> implements QzGzjlService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QzGzjlEntity> page = this.page(
                new Query<QzGzjlEntity>().getPage(params),
                new QueryWrapper<QzGzjlEntity>()
        );

        return new PageUtils(page);
    }

}