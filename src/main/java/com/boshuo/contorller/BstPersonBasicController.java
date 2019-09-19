package com.boshuo.contorller;

import java.util.Arrays;
import java.util.Map;

import com.boshuo.entity.pojo.BstPersonBasicEntity;
import com.boshuo.service.BstPersonBasicService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ${comments}
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-16 18:20:32
 */
@RestController
@RequestMapping("boshuo/bstpersonbasic")
public class BstPersonBasicController {
    @Autowired
    private BstPersonBasicService bstPersonBasicService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bstPersonBasicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{mid}")
    public R info(@PathVariable("mid") Integer mid){
		BstPersonBasicEntity bstPersonBasic = bstPersonBasicService.getById(mid);

        return R.ok().put("bstPersonBasic", bstPersonBasic);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody BstPersonBasicEntity bstPersonBasic){
		bstPersonBasicService.save(bstPersonBasic);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody BstPersonBasicEntity bstPersonBasic){
		bstPersonBasicService.updateById(bstPersonBasic);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] mids){
		bstPersonBasicService.removeByIds(Arrays.asList(mids));

        return R.ok();
    }


    @PostMapping("/insetEntity")
    public R insetEntity(){
        bstPersonBasicService.insertEntity();
        return R.ok();
    }

}
