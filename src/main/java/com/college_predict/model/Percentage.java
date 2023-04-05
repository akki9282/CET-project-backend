package com.college_predict.model;

import java.math.BigDecimal;

//import javax.persistence.*;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Percentage {
//	 @Id
////	  @GeneratedValue(strategy = GenerationType.IDENTITY)
//	  @Column(name = "id")
//	  private Long id;

	  @ManyToOne(cascade = CascadeType.PERSIST)
	  @JoinColumn(name = "branch_ID", nullable = false)
	  private Branch branch;

	  @ManyToOne(cascade = CascadeType.PERSIST)
	  @JoinColumn(name = "college_ID", nullable = false)
	  private College college;

	  @Column(name = "cap_round", nullable = false)
	  private int capRound;

	  @Column(name = "category_name", nullable = false)
	  private String categoryName;

	  @Column(name = "stage", nullable = false)
	  private String stage;

	  @Column(name = "ranking", nullable = false)
	  private int ranking;

	  @Column(name = "percentage", nullable = false, precision = 4, scale = 2)
	  private BigDecimal percentage;

}
