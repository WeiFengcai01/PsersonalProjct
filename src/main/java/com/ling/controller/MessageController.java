package com.ling.controller;

import com.ling.entity.Book;
import com.ling.entity.Message;
import com.ling.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;

    @PostMapping("/comment")
    public boolean comment(@RequestBody Message message){
        return this.messageService.save(message);
    }
}
