package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstPersonResumeEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 12:41:40
 */
public interface BstPersonResumeService extends IService<BstPersonResumeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

