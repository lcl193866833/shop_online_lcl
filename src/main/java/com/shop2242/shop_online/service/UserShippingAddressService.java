package com.shop2242.shop_online.service;

import com.shop2242.shop_online.entity.UserShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop2242.shop_online.vo.AddressVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {
    //获取收货列表
    List<AddressVO> getAddressList(Integer userId);
    //获取地址详情
    AddressVO getAddress(Integer id);
    //添加收货地址
    Integer saveShippingAddress(AddressVO addressVO);
    //修改收获地址
    Integer editShippingAddress(AddressVO addressVO);

    //删除收货地址
    void delAddress(Integer id);
}
