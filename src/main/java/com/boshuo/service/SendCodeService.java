package com.boshuo.service;

import com.boshuo.util.dto.CommonResult;

public interface SendCodeService {

    CommonResult<Void> sendCode(String username,String type);
}
