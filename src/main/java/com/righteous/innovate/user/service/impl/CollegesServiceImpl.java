package com.righteous.innovate.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.righteous.innovate.common.utils.PageUtils;
import com.righteous.innovate.common.utils.Query;

import com.righteous.innovate.user.dao.CollegesDao;
import com.righteous.innovate.user.entity.CollegesEntity;
import com.righteous.innovate.user.service.CollegesService;


@Service("collegesService")
public class CollegesServiceImpl extends ServiceImpl<CollegesDao, CollegesEntity> implements CollegesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CollegesEntity> page = this.page(
                new Query<CollegesEntity>().getPage(params),
                new QueryWrapper<CollegesEntity>()
        );

        return new PageUtils(page);
    }

}