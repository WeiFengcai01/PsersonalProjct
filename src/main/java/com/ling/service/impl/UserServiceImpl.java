package com.ling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ling.entity.User;

import com.ling.mapper.UserMapper;
import com.ling.service.ImgService;
import com.ling.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ling
 * @since 2022-06-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
