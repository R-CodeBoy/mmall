package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Yelun on 2017/6/1.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService{
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file,String path){
        String filename = file.getOriginalFilename();
        //扩展名
        //abc.jpg
        String fileExtensionName = filename.substring(filename.lastIndexOf(".")+1);
        //A:abc.jpg
        //B:abc.jpg
        //实验UUID防止客户上传同样的文件名文件导致文件覆盖的问题
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",filename,path,uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
            //文件已经上传成功了

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到ftp服务器上
            //上传后，删除upload下面的文件
            targetFile.delete();


        } catch (IOException e) {
//            e.printStackTrace();
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();

    }

}
