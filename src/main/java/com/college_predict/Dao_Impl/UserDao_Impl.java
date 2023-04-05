package com.college_predict.Dao_Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college_predict.Dao.UserDao;
import com.college_predict.dto.CollegeListDTO;
import com.college_predict.dto.UserDetailDTO;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public class UserDao_Impl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<CollegeListDTO> getCollegeList(UserDetailDTO userDetailDTO) {
		
			Session session = sessionFactory.openSession();
			String query="";
			if(userDetailDTO.getGender().equalsIgnoreCase("female")) {
			 query = "select c.college_id AS college_ID,c.college_name AS college_name,c.city AS city,\n"
					+ "c.college_type AS type,b.branch_id AS branch_ID,b.branch_name AS branch_name,\n"
					+ "p.stage AS stage,p.ranking AS ranking,p.percentage AS percentage,p.category_name AS category_name\n"
					+ "from percentage as p inner join branch as b on p.branch_ID=b.branch_ID\n"
					+ "inner join college as c on b.college_ID=c.college_ID\n"
					+ "where p.percentage<="
					+ userDetailDTO.getPercentage()
					+ " and p.category_name like '%"+userDetailDTO.getCategory() +"%';";
			}
			else {
				 query = "select c.college_id AS college_ID,c.college_name AS college_name,c.city AS city,\n"
							+ "c.college_type AS type,b.branch_id AS branch_ID,b.branch_name AS branch_name,\n"
							+ "p.stage AS stage,p.ranking AS ranking,p.percentage AS percentage,p.category_name AS category_name\n"
							+ "from percentage as p inner join branch as b on p.branch_ID=b.branch_ID\n"
							+ "inner join college as c on b.college_ID=c.college_ID\n"
							+ "where p.percentage<="
							+ userDetailDTO.getPercentage()
							+ " and p.category_name like '%"+userDetailDTO.getCategory() +"%'\n"
							+ "and p.category_name not like 'L%';";
			}
			
			NativeQuery<CollegeListDTO> q = session.createNativeQuery(query);
			q.setResultTransformer(Transformers.aliasToBean(CollegeListDTO.class));
			List<CollegeListDTO> list = q.getResultList();

			return list;
		
	}

}
