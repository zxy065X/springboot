package com.boshuo.service.Impl;

import com.boshuo.dao.resume.BstPersonResumeDao;
import com.boshuo.entity.pojo.BstPersonResumeEntity;
import com.boshuo.service.BstPersonResumeService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("bstPersonResumeService")
public class BstPersonResumeServiceImpl extends ServiceImpl<BstPersonResumeDao, BstPersonResumeEntity> implements BstPersonResumeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BstPersonResumeEntity> page = this.page(
                new Query<BstPersonResumeEntity>().getPage(params),
                new QueryWrapper<BstPersonResumeEntity>()
        );

        return new PageUtils(page);
    }

}