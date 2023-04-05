package com.college_predict.Dao;

import com.college_predict.dto.BranchDTO;
import com.college_predict.dto.PercentageDTO;
import com.college_predict.model.College;

public interface AdminDao {
	public void saveCollege(College clg);
	public void saveBranch(BranchDTO branch);
	public void savePercentage(PercentageDTO per);
}
