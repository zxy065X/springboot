package com.boshuo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boshuo.entity.pojo.BstCompanyAccountEntity;
import com.boshuo.util.dto.PageUtils;

import java.util.Map;

/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 08:50:46
 */
public interface BstCompanyAccountService extends IService<BstCompanyAccountEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void insertEntity();


}

