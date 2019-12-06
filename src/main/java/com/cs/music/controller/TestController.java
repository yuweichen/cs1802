package com.cs.music.controller;

import com.cs.music.entity.User;
import com.cs.music.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/helloWord", method = RequestMethod.GET)
    public String helloWord() {
        return "test/helloWord";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userService.selectList(null);
    }
}
