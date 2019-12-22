package com.cs.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 所有页面返回的位置
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    /**
     * index 页面
     *
     * @return
     */
    @GetMapping("index")
    public String index() {
        return "view/index";
    }

    @GetMapping("playerIndex")
    public String playerIndex() {
        return "view/player/index";
    }
}
