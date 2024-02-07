package com.example.onetoone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	ResponseEntity<String> fileupload(MultipartFile file);
	
	ResponseEntity<Object> filedownload(String filename);

	ResponseEntity<String> fileAppend(String fileName,String content);
	

}
