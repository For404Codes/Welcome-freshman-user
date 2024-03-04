package com.righteous.innovate.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.user.entity.UserAttributesEntity;
import com.righteous.innovate.user.service.UserAttributesService;
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
@RequestMapping("user/userattributes")
public class UserAttributesController {
    @Autowired
    private UserAttributesService userAttributesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userattributes:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAttributesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attributeId}")
    //@RequiresPermissions("user:userattributes:info")
    public R info(@PathVariable("attributeId") Integer attributeId){
		UserAttributesEntity userAttributes = userAttributesService.getById(attributeId);

        return R.ok().put("userAttributes", userAttributes);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userattributes:save")
    public R save(@RequestBody UserAttributesEntity userAttributes){
		userAttributesService.save(userAttributes);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userattributes:update")
    public R update(@RequestBody UserAttributesEntity userAttributes){
		userAttributesService.updateById(userAttributes);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userattributes:delete")
    public R delete(@RequestBody Integer[] attributeIds){
		userAttributesService.removeByIds(Arrays.asList(attributeIds));

        return R.ok();
    }

}
