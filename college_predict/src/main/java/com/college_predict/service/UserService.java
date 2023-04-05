package com.college_predict.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.college_predict.dto.CollegeListDTO;
import com.college_predict.dto.UserDetailDTO;

//@Component
//@Configuration
@Service
public interface UserService {
	public List<CollegeListDTO> getCollegeList(UserDetailDTO userDetailDTO);

	
	public List<CollegeListDTO> filter(List<String> collegeName, List<String> city, List<String> type, List<String> branch);
}
