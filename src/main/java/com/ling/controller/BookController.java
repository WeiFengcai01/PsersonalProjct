package com.ling.controller;


import com.ling.entity.Book;
import com.ling.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ling
 * @since 2022-06-09
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<Book> list(){
        return this.bookService.list();
    }

    @GetMapping("/findById/{id}")
//    @CrossOrigin
    public Book findById(@PathVariable("id") Integer id){
        return this.bookService.getById(id);

    }
    @DeleteMapping("/delect/{id}")
    public boolean delect(@PathVariable("id") Integer id){
        return this.bookService.removeById(id);

    }
    @PostMapping("/add")
    public boolean add(@RequestBody Book book){
        return this.bookService.save(book);
    }
    @PutMapping("update")
    private boolean update(@RequestBody Book book){
        return this.bookService.updateById(book);

    }


}

