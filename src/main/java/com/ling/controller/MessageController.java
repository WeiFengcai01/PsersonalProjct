package com.ling.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ling.entity.Message;
import com.ling.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.logging.SimpleFormatter;

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
//
//    @GetMapping("/server_info")
//    @ResponseBody
//    public String server_info() throws IOException, InterruptedException {
//
//            Process process = Runtime.getRuntime().exec("cmd /c net statistics workstation");
//
//            String startUpTime = "";
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            int i = 0;
//
//            String timeWith = "";
//
//            while ((timeWith = bufferedReader.readLine()) != null) {
//                if (i == 3) {
//                    System.out.println(timeWith);
//
//                    startUpTime = timeWith;
//
//                }
//
//                i++;
//
//            }
//
//            process.waitFor();
//
//            return startUpTime;
//
//        }
//    @GetMapping("/list")
//    @ResponseBody
//    public Data server_info(){
//        long time= ManagementFactory.getRuntimeMXBean().getStartTime();
//        Data data = new Data(time);
//        return data;
//    }


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
