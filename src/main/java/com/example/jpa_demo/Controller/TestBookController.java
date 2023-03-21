package com.example.jpa_demo.Controller;

import com.example.jpa_demo.Pojo.Entity.Book;
import com.example.jpa_demo.Service.TestBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//应用表现层
@RestController//Rest风格
@RequestMapping("/testbook")//一级标题
@Api(tags="图书管理操作接口")
public class TestBookController {
    @Autowired
    TestBookService testBookService;
    @ApiOperation(value="添加书籍",notes = "添加书籍")//Swagger 注解
    @PostMapping("/add")//二级标题
    //添加书籍
    public Boolean addTestBook(@RequestBody Book book){
        return testBookService.addBook(book);
    }
    @ApiOperation(value="删除书籍",notes = "删除书籍")
    @DeleteMapping("/{id}")
    //删除书籍
    public Boolean deleteTestBool(@PathVariable Integer id ){
        return testBookService.deleteBook(id);
    }
    @ApiOperation(value="查找书籍",notes = "查找书籍")
    @GetMapping("/{id}")
    //查询书籍
    public Book queryTestBookById(@PathVariable Integer id){
        return testBookService.findBookById(id);
    }
    @ApiOperation(value="更新书籍",notes = "更新书籍")
    @PostMapping("/update")
    //更新书籍
    public Boolean updateTestBook(@RequestBody Book book){
        return testBookService.updateBook(book);
    }
}
