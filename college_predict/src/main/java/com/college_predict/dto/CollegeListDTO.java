package com.college_predict.dto;

import java.math.BigDecimal;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CollegeListDTO {

	private int college_ID;
	private String college_name;
	private String city;
	private String type;
	private int branch_ID;
	private String branch_name;
	private String stage;
	private int ranking;
	private BigDecimal percentage;
	private String category_name;
}
