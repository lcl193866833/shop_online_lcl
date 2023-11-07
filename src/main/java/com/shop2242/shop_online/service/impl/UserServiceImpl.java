package com.shop2242.shop_online.service.impl;

import com.shop2242.shop_online.entity.User;
import com.shop2242.shop_online.mapper.UserMapper;
import com.shop2242.shop_online.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ch35tnut
 * @since 2023-11-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
