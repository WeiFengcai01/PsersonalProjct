package com.ling.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ling.entity.Message;
import com.ling.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

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
//
    @GetMapping("/server_info")
    @ResponseBody
    public String server_info(){
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        System.out.println(new Date(time));

        String str = JSON.toJSONStringWithDateFormat(new Date(time),"yyyy-MM-dd HH:mm:ss");
        return str;

        }



    @PostMapping("/agree")
    @ResponseBody
    private boolean update(@RequestBody Message message) {
        System.out.println("id="+message.getId());
        System.out.println("agger="+message.getAgree());
        System.out.println("disagree="+message.getDisagree());

        System.out.println(message);


        Message message1 = new Message();
        message1.setId(message.getId());
        message1.setDisagree(message.getDisagree());
        message1.setAgree(message.getAgree()+1);
//        return true;
        return messageService.updateById(message1);
    }



    @PostMapping("/disagree")
    @ResponseBody
    private boolean updatedisagree(@RequestBody Message message) {
        System.out.println("id="+message.getId());
        System.out.println("agger="+message.getAgree());
        System.out.println("disagree="+message.getDisagree());

        System.out.println(message);


        Message message1 = new Message();
        message1.setId(message.getId());
        message1.setDisagree(message.getDisagree()+1);
        message1.setAgree(message.getAgree());
//        return true;
        return messageService.updateById(message1);
    }




}
