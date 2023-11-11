package com.example.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.shop.entity.IndexCarousel;
import com.example.shop.mapper.IndexCarouselMapper;
import com.example.shop.service.IndexCarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
@Service

public class IndexCarouselServiceImpl extends ServiceImpl<IndexCarouselMapper, IndexCarousel> implements IndexCarouselService {

    @Override
    public List<IndexCarousel> getList(Integer distributionSite) {
        //使用wrapper设置查询条件  当distributionSite！=null时作为查询条件
        //当distributionSite=1查询首页广告
        //当distributionSite=2查询分类页广告
        LambdaQueryWrapper<IndexCarousel> wrapper=new LambdaQueryWrapper<>();
        if(distributionSite !=null){
            wrapper.eq(IndexCarousel::getType,distributionSite);
        }
        //设置排序，根据创建时间倒叙
        wrapper.orderByDesc(IndexCarousel::getCreateTime);
        //查询广告列表
        List<IndexCarousel> list=baseMapper.selectList(wrapper);
        return list;
    }
}
