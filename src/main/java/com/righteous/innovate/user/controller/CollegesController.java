package com.righteous.innovate.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.user.entity.CollegesEntity;
import com.righteous.innovate.user.service.CollegesService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.R;



/**
 * 
 *
 * @author gxj
 * @email 
 * @date 2024-03-04 16:24:02
 */
@RestController
@RequestMapping("user/colleges")
public class CollegesController {
    @Autowired
    private CollegesService collegesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:colleges:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = collegesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{collegeId}")
    //@RequiresPermissions("user:colleges:info")
    public R info(@PathVariable("collegeId") Integer collegeId){
		CollegesEntity colleges = collegesService.getById(collegeId);

        return R.ok().put("colleges", colleges);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:colleges:save")
    public R save(@RequestBody CollegesEntity colleges){
		collegesService.save(colleges);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:colleges:update")
    public R update(@RequestBody CollegesEntity colleges){
		collegesService.updateById(colleges);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:colleges:delete")
    public R delete(@RequestBody Integer[] collegeIds){
		collegesService.removeByIds(Arrays.asList(collegeIds));

        return R.ok();
    }

}
