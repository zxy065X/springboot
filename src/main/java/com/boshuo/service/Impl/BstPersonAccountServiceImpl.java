package com.boshuo.service.Impl;

import com.boshuo.dao.person.BstPersonAccountDao;
import com.boshuo.entity.pojo.BstPersonAccountEntity;
import com.boshuo.service.BstPersonAccountService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("bstPersonAccountService")
public class BstPersonAccountServiceImpl extends ServiceImpl<BstPersonAccountDao, BstPersonAccountEntity> implements BstPersonAccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstPersonAccountEntity> page = this.page(
                new Query<BstPersonAccountEntity>().getPage(params),
                new QueryWrapper<BstPersonAccountEntity>()
        );

        return new PageUtils(page);
    }

}