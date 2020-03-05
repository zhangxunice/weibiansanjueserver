package com.example.weibiansanjueserver.adminAPI;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.service.AdviceService;
import com.example.weibiansanjueserver.utils.JSONResult;
import com.example.weibiansanjueserver.vo.AdviceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/4 19:42
 */

@Controller
@RequestMapping("/admin")
public class AdminAdviceController {

    @Autowired
    private AdviceService adviceService;

    @RequestMapping("/advice")
    public ModelAndView findAll(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                @RequestParam(value = "size",defaultValue = "15")Integer size,
                                Map map){
        IPage<AdviceVO> advices = adviceService.findAdvice(page, size);
        map.put("advices",advices);
        map.put("currentPage",page);
        map.put("totalPage",new Long(advices.getPages()).intValue());
        return new ModelAndView("advice/adviceList",map);
    }


}
