package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.CompanyrecordsEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * 参加会讯的单位
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-12 09:53:29
 */
public interface CompanyrecordsService extends IService<CompanyrecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

