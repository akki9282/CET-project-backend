package com.college_predict.model;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_ID",nullable = false)
	private int branchID;	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "college_ID",nullable = false)
	private College college;
	@Column(name="branch_name",nullable = false)
	private String branchName;
		
}
