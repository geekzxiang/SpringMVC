package com.springapp.mvc.controller;

import com.apk.ApkInfo;
import com.apk.ApkUtil;
import com.apk.IconUtil;
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
        String iconPath = path + "/icon";
        File iconFolder = new File(iconPath);
        if (!iconFolder.exists()) {
            iconFolder.mkdirs();
        }
        File file = new File(path, "apk");
        String[] fileList = file.list();
        if (fileList != null) {
            List<ApkInfo> apkInfoList = new ArrayList<ApkInfo>();
            ApkUtil apkUtil = new ApkUtil();
            for (String apk : fileList) {
                String apkPath = file.getPath() + File.separator + apk;
                ApkInfo apkInfo = apkUtil.getApkInfo(apkPath);
                apkInfoList.add(apkInfo);

                String outputPath = iconPath + File.separator + apkInfo.getPackageName() + ".png";
                IconUtil.extractFileFromApk(apkPath, apkInfo.getApplicationIcon(), outputPath);
            }
            request.setAttribute("apkList", apkInfoList);
        }
        request.setAttribute("iconPath", iconPath);
        return "file";
    }

}