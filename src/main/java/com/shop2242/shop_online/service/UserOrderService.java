package com.shop2242.shop_online.service;

import com.shop2242.shop_online.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop2242.shop_online.vo.OrderDetailVO;
import com.shop2242.shop_online.vo.UserOrderVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface UserOrderService extends IService<UserOrder> {

    /**
     * 新增订单
     *
     * @param orderVO
     * @return Integer
     */
    Integer addGoodsOrder(UserOrderVO orderVO);

    /**
     * 获取订单详情
     *
     * @param id
     * @return OrderDetailVO
     */
    OrderDetailVO getOrderDetail(Integer id);
}
