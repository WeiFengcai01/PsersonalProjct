package com.ling.controller;



import com.ling.entity.Book;
import com.ling.entity.Images;

import com.ling.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping(value = "/index" ,produces = "application/json;charset=UTF-8")
public class IndexController {

        @Autowired
        private ImgService imgService;


    @ResponseBody
    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file")MultipartFile file){
        if (file.isEmpty()){
            return"空文件";
        } else {
            String fileName = file.getOriginalFilename();   //文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  //后缀名
            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            String filePath = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()+"\\src\\main\\resources\\static\\images\\";	//存储路径
            fileName = UUID.randomUUID().toString().replace("-","")+suffixName; //新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()){
                dest.getParentFile().exists();
            }
            try {
                file.transferTo(dest);
            }catch (IOException e){
                e.printStackTrace();
            }
            String filename = "images/"+fileName;
            System.out.println(filename);
            System.out.println(dest);
            imgService.save(new Images(1,filename));
            return filename;
        }
    }





    @ResponseBody
    @GetMapping("/imglist")
    public List<Images> list(){
        return this.imgService.list();
    }

}
