package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping(method = RequestMethod.GET)
    public String selectFiles(HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/");
        File file = new File(path, "apk");
        String[] fileList = file.list();
        request.setAttribute("fileList", fileList);
        return "file";
    }

}