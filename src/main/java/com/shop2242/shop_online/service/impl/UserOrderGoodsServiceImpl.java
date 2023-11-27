package com.shop2242.shop_online.service.impl;

import com.shop2242.shop_online.entity.UserOrderGoods;
import com.shop2242.shop_online.mapper.UserOrderGoodsMapper;
import com.shop2242.shop_online.service.UserOrderGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserOrderGoodsServiceImpl extends ServiceImpl<UserOrderGoodsMapper, UserOrderGoods> implements UserOrderGoodsService {

    @Override
    public void batchUserOrderGoods(List<UserOrderGoods> list) {
        saveBatch(list);
    }
}
