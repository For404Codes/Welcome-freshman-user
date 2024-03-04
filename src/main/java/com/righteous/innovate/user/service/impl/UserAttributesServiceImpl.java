package com.righteous.innovate.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.user.dao.UserAttributesDao;
import com.righteous.innovate.user.entity.UserAttributesEntity;
import com.righteous.innovate.user.service.UserAttributesService;


@Service("userAttributesService")
public class UserAttributesServiceImpl extends ServiceImpl<UserAttributesDao, UserAttributesEntity> implements UserAttributesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserAttributesEntity> page = this.page(
                new Query<UserAttributesEntity>().getPage(params),
                new QueryWrapper<UserAttributesEntity>()
        );

        return new PageUtils(page);
    }

}