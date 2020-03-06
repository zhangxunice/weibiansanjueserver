package com.example.weibiansanjueserver.adminAPI;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.enums.ResultEnum;
import com.example.weibiansanjueserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/4 14:01
 */

@Controller
@RequestMapping("/admin")
public class AdminBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("book/index");
    }

    @GetMapping("/booklist")
    public ModelAndView booklist(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "size",defaultValue = "20")Integer size,
                                 Map map){
        IPage<Books> booksList = bookService.booksList(page, size);
        map.put("booksList",booksList);
        map.put("currentPage",page);
        map.put("totalPage",new Long(booksList.getPages()).intValue());
        return new ModelAndView("book/bookList",map);
    }

    @GetMapping("/checkbooks")
    public ModelAndView checkBooks(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "size",defaultValue = "20")Integer size,
                                   Map map){
        IPage<Books> booksList = bookService.checkBooksList(page, size);
        map.put("booksList",booksList);
        map.put("currentPage",page);
        map.put("totalPage",new Long(booksList.getPages()).intValue());
        return new ModelAndView("book/checkBookList",map);
    }

    @GetMapping("/successcheck")
    public ModelAndView successcheck(String bookId,Map map){
        bookService.successCheck(bookId);
        map.put("msg", ResultEnum.SUCCESS_CHECK.getMsg());
        map.put("url","/admin/booklist");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/uncheck")
    public ModelAndView uncheck(String bookId,Map map){
        bookService.unCheck(bookId);
        map.put("msg", ResultEnum.SUCCESS_CHECK.getMsg());
        map.put("url","/admin/checkbooks");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(String bookId,Map map){
        bookService.finish(bookId);
        map.put("msg", ResultEnum.SUCCESS_CHECK.getMsg());
        map.put("url","/admin/booklist");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/bookdetail")
    public ModelAndView bookDetail(Map map){

        return new ModelAndView("book/bookdetail");
    }

}
