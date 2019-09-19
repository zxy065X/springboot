package com.boshuo.contorller;

import java.util.Arrays;
import java.util.Map;

import com.boshuo.entity.pojo.BstCompanyJobEntity;
import com.boshuo.service.BstCompanyJobService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 08:36:16
 */
@RestController
@RequestMapping("boshuo/bstcompanyjob")
public class BstCompanyJobController {
    @Autowired
    private BstCompanyJobService bstCompanyJobService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bstCompanyJobService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{jobid}")
    public R info(@PathVariable("jobid") Integer jobid){
		BstCompanyJobEntity bstCompanyJob = bstCompanyJobService.getById(jobid);

        return R.ok().put("bstCompanyJob", bstCompanyJob);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody BstCompanyJobEntity bstCompanyJob){
		bstCompanyJobService.save(bstCompanyJob);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody BstCompanyJobEntity bstCompanyJob){
		bstCompanyJobService.updateById(bstCompanyJob);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] jobids){
		bstCompanyJobService.removeByIds(Arrays.asList(jobids));

        return R.ok();
    }

}
