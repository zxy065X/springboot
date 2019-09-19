package com.boshuo.contorller;

import java.util.Arrays;
import java.util.Map;

import com.boshuo.entity.pojo.SignsEntity;
import com.boshuo.mongodb.MongoDBService;
import com.boshuo.service.SignsService;
import com.boshuo.util.dto.PageUtils;
import com.boshuo.util.dto.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-10 10:35:52
 */
@RestController
@RequestMapping("boshuo/signs")
public class SignsController {
    @Autowired
    private SignsService signsService;

    @Autowired
    MongoDBService mongoDBService;

    /**
     * 列表
     */
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = signsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @PostMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
		SignsEntity signs = signsService.getById(id);

        return R.ok().put("signs", signs);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody SignsEntity signs){
		signsService.save(signs);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody SignsEntity signs){
		signsService.updateById(signs);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody String[] ids){
		signsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @PostMapping("test")
    public R test(){
        mongoDBService.test();
        return R.ok();
    }

    @PostMapping("accountInfo")
    public R accountInfo(){
        mongoDBService.accountInfo();
        return R.ok();
    }

    @PostMapping("companies")
    public R companies(){
        mongoDBService.companies();
        return R.ok();
    }

    @PostMapping("companynews")
    public R companynews(){
        mongoDBService.companynews();
        return R.ok();
    }

    @PostMapping("companytickets")
    public R companytickets(){
        mongoDBService.companytickets();
        return R.ok();
    }


    @PostMapping("offerjobs")
    public R offerjobs(){
        mongoDBService.offerjobs();
        return R.ok();
    }


    @PostMapping("suggests")
    public R suggests(){
        mongoDBService.suggests();
        return R.ok();
    }

    @PostMapping("wxsigns")
    public R wxsigns(){
        mongoDBService.wxsigns();
        return R.ok();
    }

    @PostMapping("wechat")
    public R wechat(){
        mongoDBService.wechat();
        return R.ok();
    }

    @PostMapping("companyrecords")
    public R companyrecords(){
        mongoDBService.companyrecords();
        return R.ok();
    }

}
