package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.QzGzjlEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * 工作经历
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 17:23:04
 */
public interface QzGzjlService extends IService<QzGzjlEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

