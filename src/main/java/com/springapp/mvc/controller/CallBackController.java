package com.springapp.mvc.controller;

import com.baidu.api.Baidu;
import com.baidu.api.BaiduApiException;
import com.baidu.api.BaiduOAuthException;
import com.baidu.api.domain.User;
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
@RequestMapping("callback")
public class CallBackController {

    @RequestMapping(method = RequestMethod.GET)
    public void printWelcome(HttpServletRequest request, HttpServletResponse response) throws BaiduApiException, BaiduOAuthException, ServletException, IOException {
        BaiduStore store = new BaiduCookieStore(BaiduAppConstant.CLIENTID, request, response);
        Baidu baidu = new Baidu(BaiduAppConstant.CLIENTID, BaiduAppConstant.CLIENTSECRET, BaiduAppConstant.REDIRECTURI, store, request);
        String accessToken = baidu.getAccessToken();
        String refreshToken = baidu.getRefreshToken();
        String sessionKey = baidu.getSessionKey();
        String sessionSecret = baidu.getSessionSecret();
        User loggedInUser = baidu.getLoggedInUser();
        request.setAttribute("accessToken", accessToken);
        request.setAttribute("refreshToken", refreshToken);
        request.setAttribute("sessionKey", sessionKey);
        request.setAttribute("sessionSecret", sessionSecret);
        if (loggedInUser != null) {
            request.setAttribute("user", loggedInUser);
        }
        request.getRequestDispatcher("accesstoken.jsp").forward(request, response);
    }

}
