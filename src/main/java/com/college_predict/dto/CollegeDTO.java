package com.college_predict.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDTO {
	private Integer collegeID;
	private String collegeName;
	private String collegeType;
	private String city;
}
