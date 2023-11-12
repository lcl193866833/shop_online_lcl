package com.shop2242.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.shop2242.shop_online.common.exception.ServerException;
import com.shop2242.shop_online.convert.AddressConvert;
import com.shop2242.shop_online.entity.UserShippingAddress;
import com.shop2242.shop_online.enums.AddressDefaultEnum;
import com.shop2242.shop_online.enums.DeleteFlagEnum;
import com.shop2242.shop_online.mapper.UserShippingAddressMapper;
import com.shop2242.shop_online.service.UserShippingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop2242.shop_online.vo.AddressVO;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserShippingAddressServiceImpl extends ServiceImpl<UserShippingAddressMapper, UserShippingAddress> implements UserShippingAddressService {

    @Override
    public List<AddressVO> getAddressList(Integer userId) {
        List<UserShippingAddress> list = baseMapper.selectList(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getUserId, userId));
        return AddressConvert.INSTANCE.convertToAddressVOList(list);
    }

    @Override
    public AddressVO getAddress(Integer id) {
        UserShippingAddress address = baseMapper.selectOne(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getId, id));
        return AddressConvert.INSTANCE.convertToAddressVO(address);
    }

    @Override
    public Integer saveShippingAddress(AddressVO addressVO) {
        UserShippingAddress convert = AddressConvert.INSTANCE.convert(addressVO);
        if(addressVO.getIsDefault()== AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
            List<UserShippingAddress> list =baseMapper.selectList(new
                    LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getIsDefault,
                    AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
            if(list.size()>0){
                throw new ServerException("已经存在默认地址，请勿重复操作");
            }
        }
        save(convert);
        return convert.getId();
    }


    @Override
    public Integer editShippingAddress(AddressVO addressVO) {
        UserShippingAddress userShippingAddress = baseMapper.selectById(addressVO.getId());
        if(userShippingAddress==null){
            throw  new ServerException("地址不存在");
        }
        if(addressVO.getIsDefault()==AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
//            查询该用户是否已经存在默认地址
            UserShippingAddress address=baseMapper.selectOne(new
                    LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getUserId,
                    addressVO.getUserId()).eq(UserShippingAddress::getIsDefault,
                    AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
            if(address!=null){
                address.setIsDefault(AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue());
                updateById(address);
            }
        }
        UserShippingAddress address = AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        return address.getId();
    }

//    @Override
//    public void delAddress(Integer id) {
//        //逻辑删除,将地址的delete_flag置为1即可
//        UserShippingAddress address = baseMapper.selectOne(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getId, id));
//        if (address == null) {
//            throw new ServerException("地址不存在");
//        }
//        if (address.getIsDefault() == AddressDefaultEnum.DEFAULT_ADDRESS.getValue()) {
//            throw new ServerException("默认地址不能删除");
//        } else {
//            address.setDeleteFlag(DeleteFlagEnum.OPEN_DELETE_FLAG.getValue());
//            updateById(address);
//        }
//
//    }

    @Override
    public void delAddress(Integer id) {
        // 逻辑删除，将地址的delete_flag置为1即可
        UserShippingAddress address = baseMapper.selectOne(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getId, id));
        if (address == null) {
            throw new ServerException("地址不存在");
        }
        if (address.getIsDefault() == AddressDefaultEnum.DEFAULT_ADDRESS.getValue()) {
            throw new ServerException("默认地址不能删除");
        } else {
            // 直接执行 SQL 更新语句
            baseMapper.update(null,
                    new LambdaUpdateWrapper<UserShippingAddress>()
                            .set(UserShippingAddress::getDeleteFlag, DeleteFlagEnum.OPEN_DELETE_FLAG.getValue())
                            .eq(UserShippingAddress::getId, id)
            );
        }
    }
}