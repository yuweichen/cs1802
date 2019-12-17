package com.cs.music.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cs.music.entity.Singer;
import com.cs.music.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    ISingerService singerService;
    /**
     * index 页面
     *
     * @return
     */
    @PutMapping("/save")
    @ResponseBody
    public Singer save(Singer singer) {
        Wrapper wrapper =new EntityWrapper();
        wrapper.eq("singergender",0);
        wrapper.eq("singername","茄子");
        wrapper.like("singername","子");
        List<Singer> list = singerService.selectList(wrapper);
        wrapper = new EntityWrapper();
        wrapper.eq("name","茄子");
        singerService.delete(wrapper);
        singerService.deleteById(1L);
        singer.setSingerid(1L);
        Long id = 1L;
        int i = 1;
        String s = "1";
        char c ='1';

        singer.setSingername("111");
        singerService.updateById(singer);
        //返回符合條件的數據條數
        int i1 = singerService.selectCount(wrapper);
        Page<Singer> page =new Page<>();
        page.setCurrent(2);//當前頁
        page.setSize(10);//頁數大小
        singerService.selectPage(page, wrapper);
        singerService.selectPage(page);
        boolean insert = singerService.insert(singer);
        return singer;
    }
}
