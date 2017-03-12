package com.springapp.mvc.controller;

import com.baidu.api.BaiduApiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
@RequestMapping("userService")
public class UserServiceController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() throws BaiduApiException, ServletException, IOException {
        return "userinfo";
    }

}
