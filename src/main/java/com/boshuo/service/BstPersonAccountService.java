package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstPersonAccountEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 14:10:22
 */
public interface BstPersonAccountService extends IService<BstPersonAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

