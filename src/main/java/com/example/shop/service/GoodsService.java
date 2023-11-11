package com.example.shop.service;

import com.example.shop.VO.GoodsVO;
import com.example.shop.VO.IndexTabGoodsVO;
import com.example.shop.VO.IndexTabRecommendVO;
import com.example.shop.VO.RecommendGoodsVO;
import com.example.shop.common.result.PageResult;
import com.example.shop.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop.query.Query;
import com.example.shop.query.RecommendByTabGoodsQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface GoodsService extends IService<Goods> {
    //首页热门推荐
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);

    //猜你喜欢分页
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);

    GoodsVO getGoodsDetail(Integer id);
}
