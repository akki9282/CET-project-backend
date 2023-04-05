package com.college_predict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college_predict.dto.CollegeListDTO;
import com.college_predict.dto.UserDetailDTO;
import com.college_predict.exception.CollegeNotFoundException;
import com.college_predict.service.UserService;
//import javax.validation.Valid;
//import javax.validation.constraints.*;


@CrossOrigin
@RestController
@RequestMapping("/college-predict")

public class UserController {

	@Autowired
	UserService userService;

//	@PostMapping("/colleges")
//	public ResponseEntity<List<CollegeListDTO>> getCollegeList(@RequestBody @Valid UserDetailDTO userDetailDTO,
//			@RequestParam(value = "collegeName", required = false, defaultValue = "") List<String> collegeName,
//			@RequestParam(value = "city", required = false, defaultValue = "") List<String> city,
//			@RequestParam(value = "type", required = false, defaultValue = "") List<String> type,
//			@RequestParam(value = "branch", required = false, defaultValue = "") List<String> branch) {
//		
//		List<CollegeListDTO> list = userService.getCollegeList(userDetailDTO);
//
//		if (list.isEmpty()) {
//			throw new CollegeNotFoundException("College Not Found Based On Your Details");
//		} 
//		else if (!collegeName.isEmpty() || !city.isEmpty() || !type.isEmpty() || !branch.isEmpty()) 
//		{
//			List<CollegeListDTO> filteredList = userService.filter(collegeName, city, type, branch);
//			if (filteredList.isEmpty()) {
//
//				throw new CollegeNotFoundException("College Not Found Based On Your Filtration");
//			}
//
//			return ResponseEntity.ok(filteredList);
//		}
//		return ResponseEntity.ok(list);
//
//	}
	
	@CrossOrigin
	@GetMapping("/colleges")
	public ResponseEntity<List<CollegeListDTO>> getCollegeList(
	        @RequestParam("percentage") String percentage,
	        @RequestParam("category") String category,
	        @RequestParam("gender") String gender,
	        @RequestParam(value = "collegeName", required = false, defaultValue = "") List<String> collegeName,
			@RequestParam(value = "city", required = false, defaultValue = "") List<String> city,
			@RequestParam(value = "type", required = false, defaultValue = "") List<String> type,
			@RequestParam(value = "branch", required = false, defaultValue = "") List<String> branch){
		
		double per=Double.parseDouble(percentage);
		UserDetailDTO userDetailDTO=new UserDetailDTO(per,category,gender);
		
		List<CollegeListDTO> list = userService.getCollegeList(userDetailDTO);

		if (list.isEmpty()) {
			throw new CollegeNotFoundException("College Not Found Based On Your Details");
		} 

		else if (!collegeName.isEmpty() || !city.isEmpty() || !type.isEmpty() || !branch.isEmpty()) 
			{
				List<CollegeListDTO> filteredList = userService.filter(collegeName, city, type, branch);
				if (filteredList.isEmpty()) {
	
					throw new CollegeNotFoundException("College Not Found Based On Your Filtration");
				}
	
				return ResponseEntity.ok(filteredList);
			}
		System.out.println(list.size());
		return ResponseEntity.ok(list);

	}
	
//	@CrossOrigin
//	@GetMapping("/colleges")
//	public ResponseEntity<List<CollegeListDTO>> getCollegeList(
//	        @RequestParam("percentage") @Min(value = 1, message = "Percentage Should Be Greater Than 0") @Max(value = 100, message = "Percentage Should Be Less Than 100") @NotNull Double percentage,
//	        @RequestParam("category") @NotBlank(message = "Category Should Not Be Blank") String category,
//	        @RequestParam("gender") @Pattern(regexp="^(?i)(male|female)$", message="Gender should be either 'male' or 'female'") String gender,
//	        @RequestParam(value = "collegeName", required = false, defaultValue = "") List<String> collegeName,
//	        @RequestParam(value = "city", required = false, defaultValue = "") List<String> city,
//	        @RequestParam(value = "type", required = false, defaultValue = "") List<String> type,
//	        @RequestParam(value = "branch", required = false, defaultValue = "") List<String> branch){
//
////	    double per=Double.parseDouble(percentage);
//	    double per=percentage;
//
//	    UserDetailDTO userDetailDTO=new UserDetailDTO(per,category,gender);
//
//	    List<CollegeListDTO> list = userService.getCollegeList(userDetailDTO);
//
//	    if (list.isEmpty()) {
//	        throw new CollegeNotFoundException("College Not Found Based On Your Details");
//	    } 
//
//	    else if (!collegeName.isEmpty() || !city.isEmpty() || !type.isEmpty() || !branch.isEmpty()) 
//	        {
//	            List<CollegeListDTO> filteredList = userService.filter(collegeName, city, type, branch);
//	            if (filteredList.isEmpty()) {
//
//	                throw new CollegeNotFoundException("College Not Found Based On Your Filtration");
//	            }
//
//	            return ResponseEntity.ok(filteredList);
//	        }
////	      System.out.println("pass controller");
//	    return ResponseEntity.ok(list);
//
//	}

	
//	@GetMapping("/colleges/filter")
//	public ResponseEntity<List<CollegeListDTO>> filter(
//			@RequestParam(value = "collegeName", required = false, defaultValue = "") List<String> collegeName,
//			@RequestParam(value = "city", required = false, defaultValue = "") List<String> city,
//			@RequestParam(value = "type", required = false, defaultValue = "") List<String> type,
//			@RequestParam(value = "branch", required = false, defaultValue = "") List<String> branch) {
//		List<CollegeListDTO> list = userService.filter(collegeName, city, type, branch);
//		if (list.isEmpty()) {
//			throw new CollegeNotFoundException("College Not Found Based On Your Filtration");
//		}
//
//		return ResponseEntity.ok(list);
//
//	}

}
