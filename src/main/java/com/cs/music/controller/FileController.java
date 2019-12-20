package com.cs.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.cs.music.config.BaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Value("${cs.music.file.static-access:''}")
    public String staticAccess;

    @RequestMapping("/uploadCommonFile")
    public JSONObject uploadCommonFile(HttpServletRequest request) {
        log.info("上传文件...");
        JSONObject rep = new JSONObject();
        try {
            String folder = request.getParameter("folder");
            if (StringUtils.isEmpty(folder))
                folder = "default";
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile mFile = multipartRequest.getFile("file");
            String oldFileName = mFile.getOriginalFilename();
            String expandedName = oldFileName.substring(oldFileName.lastIndexOf("."));// 文件扩展名
            String uploadUrl = this.uploadFile(mFile, folder, expandedName);
            rep.put("fileName", oldFileName);
            rep.put("url", "/" + staticAccess + "/" + uploadUrl);
        } catch (Exception e) {
            log.error("{}", e);
        }
        return rep;
    }

    private String uploadFile(MultipartFile mFile, String folder, String expandedName) throws Exception {
        String uploadPath = BaseConfig.fileDir + folder;
        String fileName = UUID.randomUUID().toString(); // UUID命名
        fileName += expandedName;
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File toFile = new File(uploadPath, fileName);
        try (
                InputStream is = mFile.getInputStream();
                OutputStream os = new FileOutputStream(toFile);
        ) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
        }
        return "/" + folder + "/" + fileName;
    }
}
