package com.springapp.mvc.controller;

import com.apk.ApkInfo;
import com.apk.ApkUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping(method = RequestMethod.GET)
    public String selectFiles(HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/");
        File file = new File(path, "apk");
        String[] fileList = file.list();
        if (fileList != null) {
            List<ApkInfo> apkInfoList = new ArrayList<ApkInfo>();
            ApkUtil apkUtil = new ApkUtil();
            for (String apk : fileList) {
                ApkInfo apkInfo = apkUtil.getApkInfo(file.getPath() + File.separator + apk);
                apkInfoList.add(apkInfo);
            }
            request.setAttribute("apkList", apkInfoList);
        }
        return "file";
    }

}