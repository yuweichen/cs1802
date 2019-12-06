package com.cs.music.controller;

import com.cs.music.service.impl.UserDetailsBaseService;
import com.cs.music.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserDetailsBaseService userDetailsBaseService;

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(User newUser) {
        try {
            if (userDetailsBaseService.loadUserEntityByUsername(newUser.getUsername()) != null) {
                return "redirect:" + "/login?registration&error";
            } else {
                userDetailsBaseService.saveUser(newUser);
                return "redirect:" + "/login?registration&success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:" + "/login?registration&errorServer";
        }
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
