package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstPersonEducateEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 11:56:22
 */
public interface BstPersonEducateService extends IService<BstPersonEducateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

