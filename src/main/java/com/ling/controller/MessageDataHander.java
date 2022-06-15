package com.ling.controller;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * 自动生成时间
 */

@Component
@Slf4j
public class MessageDataHander implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        Object createTime = getFieldValByName("time", metaObject);
        if(ObjectUtils.isEmpty(createTime)) {
            this.setFieldValByName("time",new Date(),metaObject);
        }

        Object updateTime = getFieldValByName("updateTime", metaObject);
        if(ObjectUtils.isEmpty(updateTime)) {
            this.setFieldValByName("updateTime",new Date(),metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

}
