package com.example.shop.service;

import com.example.shop.entity.IndexCarousel;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */

public interface IndexCarouselService extends IService<IndexCarousel> {
    //首页轮播图
    List<IndexCarousel> getList(Integer distributionSite);

}
