package com.boshuo.service.Impl;

import com.boshuo.dao.qz.QzGrjbxxDao;
import com.boshuo.entity.pojo.QzGrjbxxEntity;
import com.boshuo.service.QzGrjbxxService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qzGrjbxxService")
public class QzGrjbxxServiceImpl extends ServiceImpl<QzGrjbxxDao, QzGrjbxxEntity> implements QzGrjbxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QzGrjbxxEntity> page = this.page(
                new Query<QzGrjbxxEntity>().getPage(params),
                new QueryWrapper<QzGrjbxxEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<QzGrjbxxEntity> selectqxz() {
        List<QzGrjbxxEntity> list = this.list();
        return list;
    }

}