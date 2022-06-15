package com.ling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ling.entity.Book;
import com.ling.entity.Message;
import com.ling.mapper.BookMapper;
import com.ling.mapper.MessageMapper;
import com.ling.service.BookService;
import com.ling.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
public  class MessageServiceImpl extends  ServiceImpl<MessageMapper, Message> implements MessageService{
//    ic class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService

    @Autowired
    private MessageMapper messageMapper;


}
