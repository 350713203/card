package com.card.service;

import com.card.entity.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	PicUploadResult fileUpload(MultipartFile uploadFile);

}
