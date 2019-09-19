package com.boshuo.service.Impl;

import com.boshuo.dao.accountinfo.AccountInfoDao;
import com.boshuo.entity.pojo.AccountInfoEntity;
import com.boshuo.service.AccountInfoService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("accountInfoService")
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoDao, AccountInfoEntity> implements AccountInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AccountInfoEntity> page = this.page(
                new Query<AccountInfoEntity>().getPage(params),
                new QueryWrapper<AccountInfoEntity>()
        );

        return new PageUtils(page);
    }

}