package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.CompaniesEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-10 16:36:24
 */
public interface CompaniesService extends IService<CompaniesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

