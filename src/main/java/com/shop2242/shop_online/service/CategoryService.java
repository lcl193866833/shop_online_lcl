package com.shop2242.shop_online.service;

import com.shop2242.shop_online.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop2242.shop_online.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface CategoryService extends IService<Category> {


    List<Category> getIndexCategoryList();
    /**
     * 分类tab页 - 分类列表以及各分类下的商品
     *
     * @return
     */
    List<CategoryVO> getCategoryList();

}
