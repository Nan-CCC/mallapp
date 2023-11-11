package com.example.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shop.VO.*;
import com.example.shop.common.exception.ServerException;
import com.example.shop.common.result.PageResult;
import com.example.shop.convert.GoodsConvert;
import com.example.shop.entity.Goods;
import com.example.shop.entity.IndexRecommend;
import com.example.shop.entity.IndexRecommendTab;
import com.example.shop.mapper.GoodsMapper;
import com.example.shop.mapper.IndexRecommendMapper;
import com.example.shop.mapper.IndexRecommendTabMapper;
import com.example.shop.query.Query;
import com.example.shop.query.RecommendByTabGoodsQuery;
import com.example.shop.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final IndexRecommendMapper indexRecommendMapper=null;
    private final IndexRecommendTabMapper indexRecommendTabMapper=null;
    @Override
    public IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query) {
        //1.根据推荐的recommendId查询实体
        IndexRecommend indexRecommend=indexRecommendMapper.selectById(query.getSubType());
        if(indexRecommend==null){
            throw new ServerException("推荐分类不存在");
        }
        //2查询该分类下的tab列表
        LambdaQueryWrapper<IndexRecommendTab> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(IndexRecommendTab::getRecommendId,indexRecommend.getId());
        List<IndexRecommendTab> tabList=indexRecommendTabMapper.selectList(wrapper);
        if(tabList.size()==0){
            throw new ServerException("该分类下不存在tab分类");
        }

        //3.tab分类下的商品列表
        List<IndexRecommendVO> list=new ArrayList<>();
        for(IndexRecommendTab item:tabList){
            IndexTabGoodsVO tabGoods=new IndexTabGoodsVO();
            tabGoods.setId(item.getId());
            tabGoods.setName(item.getName());
            Page<Goods> page=new Page<>(query.getPage(),query.getPageSize());
            Page<Goods> goodsPage=baseMapper.selectPage(page,new LambdaQueryWrapper<Goods>().eq(Goods::getTabId,item.getId()));
            List<RecommendGoodsVO> goodsList= GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
            PageResult<RecommendGoodsVO> result=new PageResult<>(page.getTotal(),query.);
            tabGoods.setGoodsItems(result);
            list.add(tabGoods);
        }
        IndexTabRecommendVO recommendVO=new IndexTabRecommendVO();
        recommendVO.setId(indexRecommend.getId());
        recommendVO.setName(indexRecommend.getName());
        recommendVO.setCover(indexRecommend.getCover());
        recommendVO.setSubTypes(list);

        return recommendVO;
    }



    @Override
    public PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query) {
        Page<Goods> page = new Page<>(query.getPage(), query.getPageSize());
        Page<Goods> goodsPage = baseMapper.selectPage(page, null);
        List<RecommendGoodsVO> result = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
        return new PageResult<>(page.getTotal(), query.getPageSize(), query.getPage(), page.getPages(), result);
    }

    @Override
    public GoodsVO getGoodsDetail(Integer id) {
        return null;
    }


}
