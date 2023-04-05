package com.college_predict.service_Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.college_predict.Dao.UserDao;
import com.college_predict.Dao_Impl.UserDao_Impl;
import com.college_predict.dto.CollegeListDTO;
import com.college_predict.dto.UserDetailDTO;
import com.college_predict.service.UserService;

import com.college_predict.exception.*;

@Component
@Configuration
public class UserService_Impl implements UserService {

	@Autowired
	UserDao userDao;

	List<CollegeListDTO> collegeList;

	public List<CollegeListDTO> getCollegeList(UserDetailDTO userDetailDTO) {
//		System.out.println("in getcollege list service menthod");
		
		collegeList = userDao.getCollegeList(userDetailDTO);
		sortList(collegeList);
		return collegeList;

	}

	public List<CollegeListDTO> filter(List<String> collegeName, List<String> city, List<String> type, List<String> branch) {
//		System.out.println("in filter service method");
		if (collegeList == null) {
			throw new CollegeNotFoundException("First Get All List Of College");
		}
		List<CollegeListDTO> list = collegeList.stream()
				.filter(clg -> collegeName.isEmpty() || collegeName.stream().anyMatch(c -> clg.getCollege_name().toLowerCase().contains(c.toLowerCase())))
				.filter(clg->city.isEmpty()||city.stream().anyMatch(ci->clg.getCity().toLowerCase().contains(ci.toLowerCase())))
				.filter(clg->type.isEmpty()||type.stream().anyMatch(t->clg.getType().toLowerCase().contains(t.toLowerCase())))
				.filter(clg->branch.isEmpty()||branch.stream().anyMatch(b->clg.getBranch_name().toLowerCase().contains(b.toLowerCase())))
				.collect(Collectors.toList());
		return list;
	}


	public static void sortList(List<CollegeListDTO> collegeList) {
		Collections.sort(collegeList, Comparator.comparing(CollegeListDTO::getRanking));
	}



}
