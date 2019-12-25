package wxx.boker.chapter011.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wxx.boker.chapter011.domain.vo.Book;
import wxx.boker.chapter011.domain.vo.BookJson;

import java.util.Date;

@RestController
@ApiModel
public class BookController {
    @Autowired
    private Book book;

    @GetMapping("/boot")
    @ApiOperation(value="测试api" ,notes = "测试NOTE")
    public String getBookInfo(){
        return book.toString();
    }

    @GetMapping("/bookJson")
    public BookJson getBookJson(){
        BookJson bj = new BookJson();
        bj.setAuth("谁与谁");
        bj.setName("作者");
        bj.setDate(new Date());
        bj.setPrice(new Long("22222"));
        return bj;
    }

}
