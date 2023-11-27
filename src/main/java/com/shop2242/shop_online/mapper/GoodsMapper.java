package com.shop2242.shop_online.mapper;

import com.shop2242.shop_online.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop2242.shop_online.vo.UserOrderGoodsVO;
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
public interface GoodsMapper extends BaseMapper<Goods> {

    List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);
}
