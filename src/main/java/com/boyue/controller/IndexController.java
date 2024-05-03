package com.boyue.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public Object index1() throws IOException {
        return "/index";
    }
    @RequestMapping("/web/**")
    public Object index2() throws IOException {
        return "/index";
    }
}
