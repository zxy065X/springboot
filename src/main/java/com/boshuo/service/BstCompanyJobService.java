package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstCompanyJobEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 08:36:16
 */
public interface BstCompanyJobService extends IService<BstCompanyJobEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

