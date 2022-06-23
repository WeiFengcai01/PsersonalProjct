package com.ling.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ling.entity.CommonResult;
import com.ling.entity.User;
import com.ling.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@Api("登录")
@RestController
public class UserController {





        private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UserController.class);



        @Autowired
        private UserService userService;



//        @ApiOperation("登录")

        @PostMapping("/login")
        public CommonResult login(@Validated @RequestBody User user){



            CommonResult commonResult;

            QueryWrapper<User> queryWrapper = new QueryWrapper<>();

// queryWrapper.eq("username", username);

            queryWrapper.eq("username", user.getUsername())

                    .eq("password", user.getPassword());



            user = userService.getOne(queryWrapper);

            if (user != null) {

                commonResult = CommonResult.success(user);

                LOGGER.debug("login success:{}", user);

            }else {

                commonResult = CommonResult.error(404,"登入失败");

                LOGGER.debug("login failed:{}", user);

            }

            return commonResult;

        }



    }

