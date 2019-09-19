package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.SignsEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-10 10:35:52
 */
public interface SignsService extends IService<SignsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insert(SignsEntity entity);
}

