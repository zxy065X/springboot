package com.boshuo.service.Impl;

import com.boshuo.dao.item.BstPersonItemDao;
import com.boshuo.entity.pojo.BstPersonItemEntity;
import com.boshuo.service.BstPersonItemService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("bstPersonItemService")
public class BstPersonItemServiceImpl extends ServiceImpl<BstPersonItemDao, BstPersonItemEntity> implements BstPersonItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstPersonItemEntity> page = this.page(
                new Query<BstPersonItemEntity>().getPage(params),
                new QueryWrapper<BstPersonItemEntity>()
        );

        return new PageUtils(page);
    }

}