package com.shop2242.shop_online.convert;

import com.shop2242.shop_online.entity.UserShippingAddress;
import com.shop2242.shop_online.vo.UserAddressVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserAddressConvert {

    UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);


    UserAddressVO convertToUserAddressVO(UserShippingAddress userShippingAddress);


    List<UserAddressVO> convertToUserAddressVOList(List<UserShippingAddress> list);
}