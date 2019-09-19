package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstPersonBasicEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-16 18:13:55
 */
public interface BstPersonBasicService extends IService<BstPersonBasicEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int insertEntity();
}

