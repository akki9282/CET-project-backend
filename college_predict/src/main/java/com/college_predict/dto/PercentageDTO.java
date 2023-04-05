package com.college_predict.dto;

import java.math.BigDecimal;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PercentageDTO {
	private int branchID;
	private int collegeID;
	private int capRound;
	private String categoryName;
	private String stage;
	private int ranking;
	private BigDecimal percentage;
}
