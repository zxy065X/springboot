package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstPersonItemEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 12:36:59
 */
public interface BstPersonItemService extends IService<BstPersonItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

