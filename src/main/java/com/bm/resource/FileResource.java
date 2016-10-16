package com.bm.resource;

import com.bm.entity.HealthForm;
import com.bm.model.ResultModel;
import com.bm.service.HealthFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2016/10/15.
 */
@Controller
@Api(value = "文件模块",description = "图片上传")
public class FileResource {

    @Value("${filePath}")
    private String filePath;

    @Autowired
    private HealthFormService healthFormService;
    /**
     * 上传材料
     *
     * @param request
     * @return
     */
    @RequestMapping({"/pic/upload"})
    @ResponseBody
    @ApiOperation(value = "图片上传",httpMethod = "POST")
    public ResultModel uploadMaterial(HttpServletRequest request, @RequestParam String userId, MultipartFile file) {

        if (!file.isEmpty()) {

            String originalName = file.getOriginalFilename();

            String contentType = file.getContentType();

            String suffix = contentType.substring(contentType.lastIndexOf("/")+1);

            try {
                File targetDir = new File(filePath + userId);
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                File targetFile = new File(filePath+userId+File.separator+System.currentTimeMillis()+"."+suffix);
                if (!targetFile.exists()){
                    targetFile.createNewFile();
                }
                file.transferTo(targetFile);
                HealthForm healthForm = new HealthForm();
                healthForm.setFilePath(filePath+userId+File.separator+System.currentTimeMillis()+"."+suffix);
                healthForm.setUserId(Long.valueOf(userId));
                healthFormService.saveHelthForm(healthForm);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultModel(1,"上传图片异常","");
            }

        }
        return new ResultModel(0,"success","");

    }

    /**
     * 下载材料
     *
     * @return
     */
    @RequestMapping({"/cou/material/download/{id}"})
    @ApiOperation(value = "图片下载",httpMethod = "GET")
    public void downloadMaterial(@PathVariable("id") Long id, HttpServletResponse response) {



        String filePath = "";

        File file = new File(filePath);

        //设置response的编码方式
        response.setContentType("application/x-msdownload");

        //写明要下载的文件的大小
        response.setContentLength((int) file.length());
        String fileName = "";
        //设置附加文件名
        //response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //解决中文乱码
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //读出文件到i/o流
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream buff = new BufferedInputStream(fis);

        byte[] b = new byte[1024];//相当于我们的缓存

        long k = 0;//该值用于计算当前实际下载了多少字节

        //从response对象中得到输出流,准备下载

        OutputStream myout = null;
        try {
            myout = response.getOutputStream();


            //开始循环下载

            while (k < file.length()) {

                int j = buff.read(b, 0, 1024);

                k += j;

                //将b中的数据写到客户端的内存

                myout.write(b, 0, j);
            }
            //将写入到客户端的内存的数据,刷新到磁盘

            myout.flush();
        } catch (IOException e) {

        }

    }

}
