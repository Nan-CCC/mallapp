package com.example.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.shop.VO.IndexRecommendVO;
import com.example.shop.convert.IndexRecommendConvert;
import com.example.shop.entity.IndexRecommend;
import com.example.shop.mapper.IndexRecommendMapper;
import com.example.shop.service.IndexRecommendService;
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
public class IndexRecommendServiceImpl extends ServiceImpl<IndexRecommendMapper, IndexRecommend> implements IndexRecommendService {

    @Override
    public List<IndexRecommendVO> getList() {
        LambdaQueryWrapper<IndexRecommend> wrapper=new LambdaQueryWrapper<>();
        wrapper.orderByDesc(IndexRecommend::getCreateTime);
        List<IndexRecommend> list=baseMapper.selectList(wrapper);
        List<IndexRecommendVO> results= IndexRecommendConvert.INSTANCE.convertToUserVoList(list);
        return results;
    }
}
