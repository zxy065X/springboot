package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.QzGrjbxxEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 求职者信息
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 17:23:04
 */
public interface QzGrjbxxService extends IService<QzGrjbxxEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<QzGrjbxxEntity> selectqxz();
}

