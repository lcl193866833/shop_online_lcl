package com.shop2242.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop2242.shop_online.entity.Category;
import com.shop2242.shop_online.enums.CategoryRecommendEnum;
import com.shop2242.shop_online.mapper.CategoryMapper;
import com.shop2242.shop_online.mapper.GoodsMapper;
import com.shop2242.shop_online.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private final GoodsMapper goodsMapper;

    @Override
    public List<Category> getIndexCategoryList() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
//        查询首页和分类页都推荐的分类以及在首页推荐的分类
        wrapper.eq(Category::getIsRecommend, CategoryRecommendEnum.ALL_RECOMMEND.getValue()).or().eq(Category::getIsRecommend, CategoryRecommendEnum.INDEX_RECOMMEND.getValue());
        wrapper.orderByDesc(Category::getCreateTime);
        List<Category> list = baseMapper.selectList(wrapper);
        return list;
    }
}