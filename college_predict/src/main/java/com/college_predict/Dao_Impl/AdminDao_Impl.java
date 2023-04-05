package com.college_predict.Dao_Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college_predict.Dao.AdminDao;
import com.college_predict.dto.BranchDTO;
import com.college_predict.dto.PercentageDTO;
import com.college_predict.model.College;

@Repository
public class AdminDao_Impl implements AdminDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean getCollege(College clg) {
		College college = null;
		Session session = null;
		Transaction transction = null;
		try {
			session = sessionFactory.openSession();
			transction = session.beginTransaction();
			college = session.get(College.class, clg.getCollegeID());

		} catch (RuntimeException re) {
			re.printStackTrace();

		} finally {
			session.close();
		}
		if (college == null) {
			return true;
		}
		return false;
	}

	public void saveCollege(College clg) {
		
			Session session = null;
			Transaction transction = null;
			try {
				session = sessionFactory.openSession();
				transction = session.beginTransaction();
				session.saveOrUpdate(clg);
				transction.commit();
			} catch (RuntimeException re) {
				re.printStackTrace();
				transction.rollback();

			} finally {
				session.close();
			}
	

//		    String hql = "INSERT INTO College (collegeID, collegeName, collegeType, city) VALUES (:id, :name, :type, :city)";
//		    Query query = (Query) session.createQuery(hql);

//		    for (CollegeDTO list : collegeDTO) {
//		        query.setParameter("id", list.getCollegeID());
//		        query.setParameter("name", list.getCollegeName());
//		        query.setParameter("type", list.getCollegeType());
//		        query.setParameter("city", list.getCity());
//
//		        query.executeUpdate();
//		    }
//		    session.close();

//		 tx.begin();
//		for (CollegeDTO list : collegeDTO) {
//			Session session = sessionFactory.openSession();
//			 Transaction tx = session.beginTransaction();
//			College clg = new College();
//			clg.setCollegeID(list.getCollegeID());
//			clg.setCollegeName(list.getCollegeName());
//			clg.setCollegeType(list.getCollegeType());
//			clg.setCity(list.getCity());
//			
//			College college = session.get(College.class, clg.getCollegeID());
//			if(college==null) {
//				System.out.println(":in collge null condition:");
//			try {
//				session.save(clg);
//			tx.commit();
////			session.close();
//			}
//			catch(Exception e)
//			{tx.rollback();
//				e.printStackTrace();
//			}
//			}
//		}

//		Session session = sessionFactory.openSession();
//		String sql = "INSERT INTO college (college_ID, college_name, college_type, city) VALUES (?, ?, ?, ?)";
//		Query query = (Query) session.createQuery(sql);
//
//		for (CollegeDTO list : collegeDTO) {
//		    query.setParameter(1, list.getCollegeID());
//		    query.setParameter(2, list.getCollegeName());
//		    query.setParameter(3, list.getCollegeType());
//		    query.setParameter(4, list.getCity());
//		    
//		    query.executeUpdate();
//		}
	}

	public void saveBranch(BranchDTO branch) {
		Session session = null;
		Transaction transction = null;
		try {
			session = sessionFactory.openSession();
			transction = session.beginTransaction();
//			session.saveOrUpdate(branch);
			String sql = "INSERT IGNORE INTO branch (branch_ID, college_ID, branch_name) VALUES (:branchID, :collegeID, :branchName)";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("branchID", branch.getBranchID());
			query.setParameter("collegeID", branch.getCollegeID());
			query.setParameter("branchName", branch.getBranchName());
			query.executeUpdate();
			transction.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();

			transction.rollback();
//			return;

		} finally {
			session.close();
		}
	}

	public void savePercentage(PercentageDTO per) {
		Session session = null;
		Transaction transction = null;
		try {
			session = sessionFactory.openSession();
			transction = session.beginTransaction();
			
			String sql="INSERT IGNORE INTO percentage(branch_ID,college_ID,cap_round,ranking,percentage,category_name,stage) "
					+ "values(:branchID,:collegeID,:capRound,:ranking,:percent,:categoryName,:stage); ";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("branchID", per.getBranchID());
			query.setParameter("collegeID", per.getCollegeID());
			query.setParameter("capRound", per.getCapRound());
			query.setParameter("ranking", per.getRanking());
			query.setParameter("percent", per.getPercentage());
			query.setParameter("categoryName", per.getCategoryName());
			query.setParameter("stage", per.getStage());
			query.executeUpdate();
			transction.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
			transction.rollback();

		} finally {
			session.close();
		}
	}

}
