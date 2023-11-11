package com.example.shop.service;

import com.example.shop.VO.IndexRecommendVO;
import com.example.shop.entity.IndexRecommend;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface IndexRecommendService extends IService<IndexRecommend> {

    List<IndexRecommendVO> getList();
}
