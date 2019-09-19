package com.boshuo.service;

import com.boshuo.util.dto.CommonResult;

public interface LoginService {

    CommonResult<Void> doLogin(String username,String code,String type);
}
