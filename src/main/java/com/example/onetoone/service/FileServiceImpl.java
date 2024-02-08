package com.example.onetoone.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.print.attribute.standard.Media;

import org.apache.catalina.connector.Response;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class FileServiceImpl implements FileService {

	private static final String UPLOAD_DIR = "D:\\upload";

	@Override
	public ResponseEntity<String> fileupload(MultipartFile file) {
		File directory = new File(UPLOAD_DIR);
		if (!directory.exists()) {
			directory.mkdir();
		}

		try {

			String myFile = file.getOriginalFilename();
			Path myFilePath = Paths.get(UPLOAD_DIR).resolve(myFile);

			Files.write(myFilePath, file.getBytes(), StandardOpenOption.CREATE);
			String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/author/download/")
					.path(myFile).toUriString();
			return ResponseEntity.ok("file  uploaded successfully Downloaded URL:" + fileDownloadUrl);

		} catch (Exception e) {
			ResponseEntity.status(500).body("can't upload file:" + e.getMessage());
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> filedownload(String filename) {
		ResponseEntity<Object> responce = null;
		try {

			Path myFilePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();
			File file = myFilePath.toFile();
			if (file.exists()) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", filename);
				responce = ResponseEntity.ok().headers(headers).contentLength(file.length())
						.body(new FileSystemResource(file));
			} else {
				responce = ResponseEntity.notFound().build();
			}
		} catch (Exception e) {

			responce = ResponseEntity.status(500).body("failed to download file:" + e.getMessage());
		}
		return responce;
	}

	@Override
	public ResponseEntity<String> fileAppend(String file, String content) {

		try {
			
			Path myFilePath = Paths.get(UPLOAD_DIR).resolve(file).normalize();

			if (!Files.exists(myFilePath)) {
				return new ResponseEntity<>("File not found.", HttpStatus.NOT_FOUND);
			}
			Files.write(myFilePath, content.getBytes(), StandardOpenOption.APPEND);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/author/download/")
					.path(file).toUriString();
			return ResponseEntity.ok("file appended successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("can't appended");
		}

	}

}
