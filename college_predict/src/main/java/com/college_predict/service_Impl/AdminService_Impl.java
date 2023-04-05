package com.college_predict.service_Impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.college_predict.Dao.AdminDao;
import com.college_predict.dto.BranchDTO;
import com.college_predict.dto.CollegeDTO;
import com.college_predict.dto.PercentageDTO;
import com.college_predict.model.Branch;
import com.college_predict.model.College;
import com.college_predict.model.Percentage;
import com.college_predict.service.AdminService;

@Service
public class AdminService_Impl implements AdminService {

	@Autowired
	AdminDao adminDao;

	final int capRound = 2;

	@Override
	public String savePDFdata(MultipartFile file) throws IOException {
		List<CollegeDTO> college = new ArrayList<>();
		List<BranchDTO> branch = new ArrayList<>();
		List<PercentageDTO> per = new ArrayList<>();

		List<Integer> tempBranch=new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

		XSSFSheet datatypeSheet = workbook.getSheetAt(0);

		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> iterator = datatypeSheet.iterator();

		int rowNum = 0;
		boolean forRow = false;
		int row = 0;
		int column = 0;
		int rowIndex = 0;
		int temp = 0;
		while (iterator.hasNext()) // row traverse
		{

			Row currentRow = iterator.next();

			Iterator<Cell> cellIterator = currentRow.iterator();

			boolean stages = false;

			while (cellIterator.hasNext()) { // cell iterate

				Cell currentCell = cellIterator.next();

				// extract college and branch details
				if (currentCell.getColumnIndex()==0 && currentCell.getStringCellValue().length() > 20
						&& currentCell.getStringCellValue().indexOf("-") == 5) {

					String input = currentCell.getStringCellValue();
					input = input.replaceAll("   ", "");

					if (!input.contains(", ")) {
						input = input.replaceAll(",", ", ");
					}
					String[] lines = input.split("\n");

					// Extract college ID and name
					String[] collegeInfo = lines[0].split(" - ");
					int collegeID = Integer.parseInt(collegeInfo[0].trim());
					String collegeName = collegeInfo[1].trim();

					// Extract branch ID and name
					String[] branchInfo = lines[1].split(" - ");
//					int branchID = Integer.parseInt(branchInfo[0].trim());
					int branchID;
					if(branchInfo[0].contains("F")||branchInfo[0].contains("K"))
					{
							int l=branchInfo[0].length()-1;
						 branchID = Integer.parseInt(branchInfo[0].substring(0,l));
						 tempBranch.add(branchID);
					}
					else {
					 branchID = Integer.parseInt(branchInfo[0].trim());
					}
					
					String branchName = branchInfo[1].split("Status:")[0].trim();

					// Extract college type
					String collegeType = "";
					if (lines[1].contains("Status")) {
						collegeType = lines[1].split(": ")[1].trim();
					} else {
						collegeType = lines[2].split(": ")[1].trim();
					}

					// Extract city from college name
					String[] collegeNameParts = collegeName.split(", ");
					String city = collegeNameParts[collegeNameParts.length - 1];
					if (city.contains(".")) {
						city = city.substring(0, city.indexOf('.'));
					}

					// Print extracted information

					// add college
					CollegeDTO clg = new CollegeDTO();
					clg.setCollegeID(collegeID);
					clg.setCollegeName(collegeName);
					clg.setCollegeType(collegeType);
					clg.setCity(city);

					// add branch
					BranchDTO b = new BranchDTO();

					b.setBranchID(branchID);
					b.setCollegeID(clg.getCollegeID());
					b.setBranchName(branchName);

					college.add(clg);
					branch.add(b);

				}

				// Extract branch
				if (currentCell.getColumnIndex()==0 && currentCell.getStringCellValue().indexOf("-") == 10) {

					String input = currentCell.getStringCellValue();
					String[] lines = input.split("\n");

					// Extract branch ID and name
					String[] branchInfo = lines[0].split(" - ");
//					branchInfo[0]
					int branchID;
					if(branchInfo[0].contains("F")||branchInfo[0].contains("K"))
					{int l=branchInfo[0].length()-1;
						 branchID = Integer.parseInt(branchInfo[0].substring(0,l).trim());
						 tempBranch.add(branchID);

					}
					else {
					 branchID = Integer.parseInt(branchInfo[0].trim());
					}
					String branchName = branchInfo[1].split("Status:")[0].trim();

					// Extract college type
//					String collegeType = "";
//					if (lines[1].contains("Status")) {
//						collegeType = lines[0].split(": ")[1].trim();
//					} else {
//						collegeType = lines[0].split(": ")[1].trim();
//					}

					// add branch
					CollegeDTO clg = college.get(college.size() - 1);

					BranchDTO b = new BranchDTO();
					b.setBranchID(branchID);
					b.setBranchName(branchName);
					b.setCollegeID(clg.getCollegeID());

					branch.add(b);

				}

				// fetching data of table

				Row currentRow1 = null;

				// increment collum
				if (currentCell.getColumnIndex()==1 && currentCell.getStringCellValue().equalsIgnoreCase("Stage") || stages == true) {
					forRow = true;
					if (stages == false) {

						rowIndex = currentCell.getRowIndex();
						temp = rowIndex;

					}
					if (!currentCell.getStringCellValue().isEmpty()) {
						column++;
						stages = true;
					} else {
						stages = false;
					}

				}

				// increment row
				if (forRow && currentCell.getColumnIndex() == 1) {
					if (!currentCell.getStringCellValue().isEmpty()) {
						row++;

					} else {

						// fetch data
						forRow = false;

						// collecting table data
						currentRow1 = sheet.getRow(temp);
						if (currentRow1 == null) {

						} else {

							int currentRowIndex = currentRow1.getRowNum();

							String[] stage = new String[row];
							int BranchSize = branch.size() - 1;
							int clgSize = college.size() - 1;
							BranchDTO branchDTO = branch.get(BranchSize);
							CollegeDTO collegeDTO = college.get(clgSize);

							for (int i = 1; i <= column; i++) {
								PercentageDTO p = new PercentageDTO();
								currentRow1 = sheet.getRow(temp);
								int temp1 = temp;
								for (int j = 1; j <= row; j++) {
									Cell cell = currentRow1.getCell(i);

									if (i == 1) {
										int index = j - 1;
										stage[index] = cell.getStringCellValue();
										currentRow1 = sheet.getRow(++temp1);
										continue;
									}

									else {
										if (cell.getStringCellValue().isBlank()) {
											currentRow1 = sheet.getRow(++temp1);
											continue;
										} else {
											if (j == 1) {

												p.setCategoryName(cell.getStringCellValue());
												currentRow1 = sheet.getRow(++temp1);
												continue;
											} else {

												String str = cell.getStringCellValue();
												if(str.contains("("))
												{
												int index = str.indexOf("(");

												if (index == -1) { // first format: no line break
													index = str.indexOf(")");
												}

												else {
													String rankStr = str.substring(0, index).trim();
													int rank = Integer.parseInt(rankStr);
													System.out.println("rank:=:"+rank);
													String percentageStr = str.substring(index + 1, str.length() - 1)
															.trim();
													double percentage = Double.parseDouble(percentageStr);
//													BigDecimal percent = new BigDecimal(percentageStr);
													
													percentage = Math.round(percentage * 100.0) / 100.0; // rounding off
													// to 2
													BigDecimal percent = new BigDecimal(Double.toString(percentage));												// decimal
													// places
													System.out.println("percentage++"+percentage);
													System.out.println("branch ID:"+branchDTO.getBranchID());
													p.setRanking(rank);
													p.setPercentage(percent);
												}
												int index1 = j - 1;
												p.setStage(stage[index1]);
												p.setBranchID(branchDTO.getBranchID());
												p.setCapRound(capRound);
												p.setCollegeID(collegeDTO.getCollegeID());
											}
												else {
													String rankStr = str;
													int rank = Integer.parseInt(rankStr.substring(0,rankStr.length()-1));
													System.out.println("rank=="+rank);
													int index1 = j - 1;
													p.setStage(stage[index1]);
													p.setBranchID(branchDTO.getBranchID());
													p.setCapRound(capRound);
													p.setCollegeID(collegeDTO.getCollegeID());
													
													currentRow1 = sheet.getRow(++temp1);
													Cell cellTemp = currentRow1.getCell(i);
													double pTemp=cellTemp.getNumericCellValue();
													double convertedNumber = Math.abs(pTemp); // Get absolute value
													convertedNumber = Math.round(convertedNumber * 100.0) / 100.0; // Round to 2 decimal places
//													System.out.println(convertedNumber); // Output: 71.12

//													String pTempStr=pTemp.substring(1, pTemp.length() - 1);
													BigDecimal percent = new BigDecimal(Double.toString(convertedNumber));
													System.out.println("percent=="+percent);
													System.out.println("branch ID:"+branchDTO.getBranchID());

//													System.out.println("=======================================");
//													System.out.println("rank:::::"+rank);
//													System.out.println(percent);
													
													
//													System.out.println("==================main thing==============");
													p.setRanking(rank);
													p.setPercentage(percent);
//													if (i > 1) {
//
//														per.add(p);
//														continue;
//													}
												}
											}
										}
										currentRow1 = sheet.getRow(++temp1);
									}

								}
								if (i > 1) {

									per.add(p);
								}
							}

						}

						row = 0;
						column = 0;
					}
				}

			}

		}

//		for (PercentageDTO p : per) {
//			System.out.println("{");
//		System.out.println(p.getBranchID());
//		System.out.println(p.getCategoryName());
//		System.out.println(p.getStage());
//		System.out.println(p.getRanking());
//		System.out.println(p.getPercentage());
//		System.out.println("}");
//	}
//		System.out.println("size of tempBranch:"+tempBranch.size());
//		for(Integer tempbranch:tempBranch)
//		{
//			System.out.println("branch ID with character:"+tempbranch);
//		}
		
		
//		 save college details
		for (CollegeDTO list : college) {
			College clg = new College();
			clg.setCollegeID(list.getCollegeID());
			clg.setCollegeName(list.getCollegeName());
			clg.setCollegeType(list.getCollegeType());
			clg.setCity(list.getCity());
			adminDao.saveCollege(clg);
		}

		// save branch details
		for (BranchDTO bDTO : branch) {
//			BranchDTO b = new BranchDTO();
			adminDao.saveBranch(bDTO);

		}

		 //save percenatge and category details
		for (PercentageDTO p : per) {
//			PercentageDTO percent = p;
			adminDao.savePercentage(p);
		}

		return "success";

	}

}
