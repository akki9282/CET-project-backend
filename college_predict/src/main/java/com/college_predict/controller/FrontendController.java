package com.college_predict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/college-predict")
public class FrontendController {

	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/data-table")
	public String data()
	{
		return "data-table";
	}
}
