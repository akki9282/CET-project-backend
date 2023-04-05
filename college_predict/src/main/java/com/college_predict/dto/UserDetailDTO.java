package com.college_predict.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {

	@Min(value = 1,message = "Percentage Should Be Greater Than 0")
	@Max(value = 100,message = "Percentage Should Be Less Than 100")
	@NotNull
	double percentage;
//	@Min(value = 1,message = "Rank Should Be Greater Than 1")
//	long rank;
	@NotBlank(message = "Category Should Not Be Blank")
	String category;
    @Pattern(regexp="^(?i)(male|female)$", message="Gender should be either 'male' or 'female'")
	String gender;
}
