package com.card.service.impl;

import com.card.entity.PicUploadResult;
import com.card.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
	private String localPath="E:/jt-upload/";
	private String imageUrl = "http://image.jt.com/";
	
	@Override
	public PicUploadResult fileUpload(MultipartFile uploadFile) {
		PicUploadResult picUploadResult = new PicUploadResult();
		//一.判断图片类型
		//1.获取文件名称     abc.jpg 
		String fileName=uploadFile.getOriginalFilename();
		//2.为了文件名称大小写一致,统统转化为小写
		fileName=fileName.toLowerCase();
		if(!fileName.matches("^.*\\.(jpg|png|gif)$")){
			picUploadResult.setError(1);
			return picUploadResult;
		}
		//二.判断是否为恶意程序
		//2.将文件转化为图片类型,获取宽度和高度
		try {
			BufferedImage image=ImageIO.read(uploadFile.getInputStream());
			int height = image.getHeight();
			int width = image.getWidth();
			if(height==0 || width==0){
				picUploadResult.setError(1);
				return picUploadResult;
			}
			
			//表示上传的文件是图片!!
			//三 分文件存储     2018/10/01
			//文件夹
			String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			//判断文件夹是否存在
			String localDirPath=localPath+dateDir;
			File fileDir = new File(localDirPath);
			if(!fileDir.exists()){
				fileDir.mkdirs();
			}
			
			//四.防止文件名称重复
			String fileType = fileName.substring(fileName.lastIndexOf("."));//jpg
			String uuid = UUID.randomUUID().toString().replace("-", "");
			int randomNum = new Random().nextInt(1000);
			//完整的图片名
			String realFileName=uuid+randomNum+fileType;
			//5.实现文件上传  将文件上传到本地磁盘下
			//E:/jt-upload/2018/10/01/32位+1-3位.jpg
			String localFilePath=localDirPath+"/"+realFileName;
			
			uploadFile.transferTo(new File(localFilePath));
			
			/**
			 * 为了实现图片回显需要编辑虚拟路径
			 * http://image.jt.com/2018/10/09/aqwerqwe.jpg
			 */
			String imageUrlPath = imageUrl + dateDir +"/" + realFileName;
			picUploadResult.setUrl(imageUrlPath);
			picUploadResult.setHeight(height+"");
			picUploadResult.setWidth(width+"");

			
		} catch (IOException e) {
			e.printStackTrace();
			picUploadResult.setError(1);
			return picUploadResult;
		}
		
		
		return picUploadResult;
	}
	
	
}
