package com.example.weibiansanjueserver.adminAPI;

import com.example.weibiansanjueserver.entity.Swiper;
import com.example.weibiansanjueserver.service.SwiperService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/7 11:12
 */

@Controller
@RequestMapping("/admin")
public class AdminSwiperController {

    @Autowired
    private SwiperService swiperService;

    @GetMapping("/swiperlist")
    public ModelAndView swiperList(Map map){
        List<Swiper> swiperList = swiperService.findAll();
        map.put("swiperList",swiperList);
        return new ModelAndView("swiper/swiperList",map);
    }

    @PostMapping("/addswiper")
    public ModelAndView addSwiper(@RequestParam("file") MultipartFile multipartFile,Map map) throws IOException {

        //文件命名空间
        String fileSpace="E:\\weibiansanjue";
        //保存到数据库的相对路径
        String uploadPathDB="/swiper";

        FileOutputStream fileOutputStream=null;
        InputStream inputStream=null;

        try {
            if (multipartFile!=null){


                String fileName=multipartFile.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)){
                    String finalPath=fileSpace+uploadPathDB+"/"+fileName;
                    uploadPathDB+=("/"+fileName);

                    File outfile=new File(finalPath);
                    if (outfile.getParentFile()!=null||!outfile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outfile.getParentFile().mkdirs();
                    }
                    fileOutputStream=new FileOutputStream(outfile);
                    inputStream= multipartFile.getInputStream();
                    IOUtils.copy(inputStream,fileOutputStream);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }

        Swiper swiper=new Swiper();
        swiper.setImgUrl(uploadPathDB);
        swiperService.addSwiper(swiper);
        map.put("msg", "添加成功");
        map.put("url", "/admin/swiperlist");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/delswiper")
    public ModelAndView delSwiper(String swiperId,Map map){
        swiperService.delSwiper(swiperId);
        map.put("msg", "删除成功");
        map.put("url", "/admin/swiperlist");
        return new ModelAndView("common/success", map);
    }

}
