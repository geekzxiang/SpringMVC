package com.springapp.mvc.controller;

import com.baidu.api.Baidu;
import com.baidu.api.BaiduApiException;
import com.baidu.api.BaiduOAuthException;
import com.baidu.api.store.BaiduCookieStore;
import com.baidu.api.store.BaiduStore;
import com.springapp.mvc.BaiduAppConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("oauthCode")
public class OAuthController {

    @RequestMapping(method = RequestMethod.POST)
    public void printWelcome(HttpServletRequest request, HttpServletResponse response) throws BaiduApiException, BaiduOAuthException, IOException {
        BaiduStore store = new BaiduCookieStore(BaiduAppConstant.CLIENTID, request, response);
        Baidu baidu = new Baidu(BaiduAppConstant.CLIENTID, BaiduAppConstant.CLIENTSECRET, BaiduAppConstant.REDIRECTURI, store, request);
        String state = baidu.getState();
        Map<String, String> params = new HashMap<String, String>();
        params.put("state", state);
        String authorizeUrl = baidu.getBaiduOAuth2Service().getAuthorizeUrl(params);
        response.sendRedirect(authorizeUrl);
    }

}
