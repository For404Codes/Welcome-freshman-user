package com.righteous.innovate.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.righteous.innovate.user.entity.UsersEntity;
import com.righteous.innovate.user.service.UsersService;
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
@RequestMapping("user/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:users:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    //@RequiresPermissions("user:users:info")
    public R info(@PathVariable("userId") Integer userId){
		UsersEntity users = usersService.getById(userId);

        return R.ok().put("users", users);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:users:save")
    public R save(@RequestBody UsersEntity users){
		usersService.save(users);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:users:update")
    public R update(@RequestBody UsersEntity users){
		usersService.updateById(users);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:users:delete")
    public R delete(@RequestBody Integer[] userIds){
		usersService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
