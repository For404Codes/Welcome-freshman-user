package com.righteous.innovate.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.user.entity.UserAttributesEntity;

import java.util.Map;

/**
 * 
 *
 * @author gxj
 * @email 
 * @date 2024-03-04 16:24:02
 */
public interface UserAttributesService extends IService<UserAttributesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

