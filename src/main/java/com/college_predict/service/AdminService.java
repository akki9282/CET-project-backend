package com.college_predict.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AdminService {
	public String savePDFdata(MultipartFile file) throws IOException;
}
