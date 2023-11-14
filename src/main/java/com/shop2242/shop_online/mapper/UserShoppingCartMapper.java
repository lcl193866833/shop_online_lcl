package com.shop2242.shop_online.mapper;

import com.shop2242.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop2242.shop_online.vo.CartGoodsVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {
    /**
     * 获取购物车信息
     *
     * @param id
     * @return list
     */
    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);
}