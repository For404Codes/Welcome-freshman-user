package com.righteous.innovate.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.user.entity.CollegesEntity;

import java.util.Map;

/**
 * 
 *
 * @author gxj
 * @email 
 * @date 2024-03-04 16:24:02
 */
public interface CollegesService extends IService<CollegesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

