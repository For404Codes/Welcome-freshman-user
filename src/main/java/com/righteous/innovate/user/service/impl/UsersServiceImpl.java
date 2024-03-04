package com.righteous.innovate.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.user.dao.UsersDao;
import com.righteous.innovate.user.entity.UsersEntity;
import com.righteous.innovate.user.service.UsersService;


@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersEntity> page = this.page(
                new Query<UsersEntity>().getPage(params),
                new QueryWrapper<UsersEntity>()
        );

        return new PageUtils(page);
    }

}