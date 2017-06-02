package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Yelun on 2017/6/1.
 */
public interface IFileService {
    public String upload(MultipartFile file, String path);
}
