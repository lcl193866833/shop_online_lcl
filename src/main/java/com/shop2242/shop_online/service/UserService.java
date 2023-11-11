package com.shop2242.shop_online.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shop2242.shop_online.entity.User;
import com.shop2242.shop_online.query.UserLoginQuery;
import com.shop2242.shop_online.vo.LoginResultVO;
import com.shop2242.shop_online.vo.UserVO;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
public interface UserService extends IService<User> {

    User getUserInfo(Integer userId);
    LoginResultVO login(UserLoginQuery query);
//修改用户信息
    UserVO editUserInfo(UserVO userVO);
}
