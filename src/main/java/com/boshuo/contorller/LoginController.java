package com.boshuo.contorller;

import com.boshuo.annotation.Param;
import com.boshuo.service.LoginService;
import com.boshuo.util.dto.CommonResult;
import com.boshuo.util.dto.Ref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/27 9:25
 * @description：登陆
 * @modified By：
 * @version: 1.0
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    /**验证登陆信
     * create by: zhangxy
     * description: TODO
     * create time: 2019/8/27 9:39
     *
      * @Param: null
     * @return
     */
    @PostMapping("doLogin")
    public CommonResult<Void> doLogin(@Param String username, @Param String code, @Param(regulation = "1,2",type = Param.ParamType.QUALIFIER) String type){
        loginService.doLogin(username,code,type);
        return Ref.ok();
    }
}
