package com.cs.music.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseConfig {
    public static String fileDir;

    @Value("${cs.music.file.dir:''}")
    public void setFileDir(String fileDir) {
        BaseConfig.fileDir = fileDir;
    }
}
