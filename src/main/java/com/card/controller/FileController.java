package com.card.controller;

import com.card.entity.PicUploadResult;
import com.card.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	//文件上传后重定向到文件上传页面
		@RequestMapping("/file")
		public String file(MultipartFile pic) throws IllegalStateException, IOException{
			//1.定义上传文件
			File file = new File("E:/jt-upload");
			
			//2.判断文件夹是否存在
			if(!file.exists()){
				//新建多级文件夹
				file.mkdirs();
			}
			//获取文件名称   abc.jpg
			String fileName = pic.getOriginalFilename();
			pic.transferTo(new File("E:/jt-upload/"+fileName)); //实现文件上传
			
			return "redirect:/file.jsp";
		}

		
		//实现图片文件上传
		@RequestMapping("/pic/upload")
		@ResponseBody
		public PicUploadResult fileUpload(MultipartFile uploadFile){
			return fileService.fileUpload(uploadFile);
		}
	
}
