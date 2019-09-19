package com.boshuo.service.Impl;

import com.boshuo.dao.wxsigns.WxsignsDao;
import com.boshuo.entity.pojo.WxsignsEntity;
import com.boshuo.service.WxsignsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("wxsignsService")
public class WxsignsServiceImpl extends ServiceImpl<WxsignsDao, WxsignsEntity> implements WxsignsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxsignsEntity> page = this.page(
                new Query<WxsignsEntity>().getPage(params),
                new QueryWrapper<WxsignsEntity>()
        );

        return new PageUtils(page);
    }

}