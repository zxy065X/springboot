package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.QzXlxxEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * 学历信息
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 17:23:04
 */
public interface QzXlxxService extends IService<QzXlxxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

