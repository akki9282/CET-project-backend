package com.college_predict.model;





import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "college_ID")
	private int collegeID;
	@Column(name = "college_name",nullable = false)
	private String collegeName;
	@Column(name = "college_type",nullable = false)
	private String collegeType;
	@Column(name="city",nullable = false)
	private String city;
}
