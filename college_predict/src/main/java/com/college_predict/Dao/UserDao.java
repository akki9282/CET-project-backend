package com.college_predict.Dao;

import java.util.List;

import com.college_predict.dto.CollegeListDTO;
import com.college_predict.dto.UserDetailDTO;

public interface UserDao {
	public List<CollegeListDTO> getCollegeList(UserDetailDTO userDetailDTO);
}
