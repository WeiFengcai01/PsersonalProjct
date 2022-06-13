package com.ling.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ling.entity.Message;
import com.ling.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    private Object Message;

    @PostMapping("/comment")
    @ResponseBody
    public boolean comment(@RequestBody Message message){
        System.out.println(message);
        return messageService.save(message);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Message> list(){
        System.out.println("list");
//        System.out.println(messageService.list());

        return this.messageService.list();
    }

    @GetMapping("/server_info")
    @ResponseBody
    public void server_info(){
        System.out.println("server_info");
        return ;
    }



    @PostMapping("/agree")
    @ResponseBody
    private UpdateWrapper update(@RequestBody Message message){
        System.out.println("agree");
//        return this.messageService.update(Wrappers.update(Message).setSql("`read_count`=`read_count`+1"));
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id",message.getAgree());
        wrapper.setSql("'agree' = 'agree' + 1");


        messageService.update(wrapper);
        return wrapper;




    }


}
