package com.boshuo.contorller;

import java.util.Arrays;
import java.util.Map;

import com.boshuo.entity.pojo.BstCompanyAccountEntity;
import com.boshuo.service.BstCompanyAccountService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 08:50:46
 */
@RestController
@RequestMapping("boshuo/bstcompanyaccount")
public class BstCompanyAccountController {
    @Autowired
    private BstCompanyAccountService bstCompanyAccountService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bstCompanyAccountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{comid}")
    public R info(@PathVariable("comid") Integer comid){
		BstCompanyAccountEntity bstCompanyAccount = bstCompanyAccountService.getById(comid);

        return R.ok().put("bstCompanyAccount", bstCompanyAccount);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody BstCompanyAccountEntity bstCompanyAccount){
		bstCompanyAccountService.save(bstCompanyAccount);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody BstCompanyAccountEntity bstCompanyAccount){
		bstCompanyAccountService.updateById(bstCompanyAccount);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] comids){
		bstCompanyAccountService.removeByIds(Arrays.asList(comids));

        return R.ok();
    }

}
