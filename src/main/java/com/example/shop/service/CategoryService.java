package com.example.shop.service;

import com.example.shop.VO.CategoryVO;
import com.example.shop.entity.Category;
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
public interface CategoryService extends IService<Category> {
    //首页分类列表
    List<Category> getIndexCategoryList();

    //分类tab页
    List<CategoryVO> getCategoryList();
}
