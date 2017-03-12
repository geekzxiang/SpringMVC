package com.springapp.mvc.controller;

import com.baidu.api.BaiduApiClient;
import com.baidu.api.BaiduApiException;
import com.baidu.api.BaiduOAuthToken;
import com.baidu.api.domain.Session;
import com.baidu.api.service.IUserService;
import com.baidu.api.service.impl.UserServiceImpl;
import com.baidu.api.store.BaiduCookieStore;
import com.baidu.api.store.BaiduStore;
import com.springapp.mvc.BaiduAppConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("--------userInfo")
public class UserInfoController {

    @RequestMapping(method = RequestMethod.GET)
    public void printWelcome(HttpServletRequest request, HttpServletResponse response) throws BaiduApiException, ServletException, IOException {
        BaiduStore store = new BaiduCookieStore(BaiduAppConstant.CLIENTID, request, response);
        Session session = store.getSession();
        BaiduOAuthToken baiduOAuthToken = session.getToken();
        String token = baiduOAuthToken.getAccessToken();
        IUserService userService = new UserServiceImpl(new BaiduApiClient(token));
        long uid = 0;
        String userParameter = request.getParameter("uid");
        if (userParameter != null && !userParameter.trim().equals("")) {
            uid = Long.valueOf(userParameter);
        }
        String fields = request.getParameter("fields");
        String[] split = fields.split(",");
        String info = userService.getInfo(uid, split);
        request.setAttribute("result", info);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

}
