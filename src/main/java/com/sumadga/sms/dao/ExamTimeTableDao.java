package com.sumadga.sms.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sumadga.sms.dto.ExamTimeTable;
import com.sumadga.sms.utils.CommonUtils;

@Repository
public class ExamTimeTableDao {

	private static final Logger logger = Logger.getLogger(ExamTimeTableDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(ExamTimeTable entity) {
		logger.info("saving ExamTimeTable instance");
		try {
			entity.setCreatedTime(new Date());
			entity.setModifiedTime(new Date());
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(ExamTimeTable entity) {
		logger.info("deleting ExamTimeTable instance");
		try {
			entity = entityManager.getReference(ExamTimeTable.class,
					entity.getExamTimeTableId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public ExamTimeTable update(ExamTimeTable entity) {
		logger.info("updating ExamTimeTable instance");
		try {
			ExamTimeTable result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public ExamTimeTable findById(Long id) {
		logger.info("finding ExamTimeTable instance with id: " + id);
		try {
			ExamTimeTable instance = entityManager.find(ExamTimeTable.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExamTimeTable> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding ExamTimeTable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from ExamTimeTable model where model."
					+ propertyName + "= :propertyValue";

			Query query = entityManager.createQuery(queryString,ExamTimeTable.class);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> findByProperties(Map<String, String> requestMap) {
		
		logger.info("finding ExamTimeTable instance with few properties ");
		try {
			
			String [] properties = {"examTypeId","classId","subjectId","teachingStaffId","examDate","examStartTime","examEndTime","maximumMarks"};
			StringBuilder queryString = new StringBuilder("select model.examTimeTableId from ExamTimeTable model where ");
			
			for(int i=0;i<properties.length;i++){
				if(i==0){
					queryString.append(" model."+properties[i]+" = '"+requestMap.get(properties[i])+"' ");
				}else if(i== 5|| i == 6){ // "examStartTime","examEndTime"
					queryString.append(" and model."+properties[i]+" = '"+CommonUtils.StringToTime(requestMap.get(properties[i]))+"' ");
				// 
			    }else if(i == 4){ // "examDate"
			    	queryString.append(" and model."+properties[i]+" = '"+CommonUtils.convertDateInString_ToOtherFormat_DateInString(requestMap.get(properties[i]),"MM-dd-yyyy","yyyy-dd-MM")+"' ");
			    }else{
					queryString.append(" and model."+properties[i]+" = '"+requestMap.get(properties[i])+"' ");
				}
			}
		
		/*	String queryString = "select e.examTimeTableId from ExamTimeTable e where e.examTypeId = :examTypeId and "
					+ "e.classclassId = :classclassId and e.subjectId = :subjectId and e.teachingStaffId = :teachingStaffId and examDate = :examDate and examStartTime = :examStartTime and examEndTime = :examEndTime and maximumMarks = :maximumMarks ";
			
			Query query = entityManager.createQuery(queryString);
			query.setParameter("examTypeId", requestMap.get("examTypeId"));
			query.setParameter("classclassId", requestMap.get("classclassId"));
			query.setParameter("subjectId", requestMap.get("subjectId"));
			query.setParameter("teachingStaffId", requestMap.get("teachingStaffId"));
			query.setParameter("examDate", requestMap.get("examDate"));
			query.setParameter("examStartTime", requestMap.get("examStartTime"));
			query.setParameter("examEndTime", requestMap.get("examEndTime"));
			query.setParameter("maximumMarks", requestMap.get("maximumMarks"));
			
			em.createQuery(
					"SELECT e.name, e.department.name " +
					"FROM Project p JOIN p.employees e " +
					"WHERE p.name = ?1 " +
					"ORDER BY e.name")
					.setParameter(1, projectName)
					.getResultList();
					
					*/

			
	//		queryString.append(" ;");
			logger.info("The query is : "+queryString);
			Query query = entityManager.createNativeQuery(queryString.toString());
			List<Integer> ids= query.getResultList();
			return ids;
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ExamTimeTable> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all ExamTimeTable instances");
		try {
			final String queryString = "select model from ExamTimeTable model";
			Query query = entityManager.createQuery(queryString,
					ExamTimeTable.class);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}
}
