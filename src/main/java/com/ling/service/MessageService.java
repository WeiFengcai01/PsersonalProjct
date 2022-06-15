package com.ling.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import com.ling.entity.Message;
import com.ling.service.impl.MessageServiceImpl;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ling
 * @since 2022-06-09
 */
public interface MessageService extends IService<Message> {


}
