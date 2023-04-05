package com.college_predict.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college_predict.exception.FileFormatWrongException;
import com.college_predict.service.AdminService;

@RestController
@RequestMapping("/college-predict")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	final String fileType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	@PostMapping("/upload")
	public ResponseEntity<?> savePDFdata(@RequestParam("file") MultipartFile file) throws IOException
	{
		if(!file.getContentType().equals(fileType))
		{
			throw new FileFormatWrongException("Wrong File Format Only .xlsx Allowed");
		}
		
		String str = adminService.savePDFdata(file);
		
		if(str.equals("success")) {
		return ResponseEntity.status(HttpStatus.CREATED).body("File Upload Successfully In Database");}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("read fail");
		
	}
}
