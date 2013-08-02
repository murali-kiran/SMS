package com.sumadga.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sumadga.sms.dto.Designations;

@Repository
public class DesignationsDao {

	private static final Logger logger = Logger.getLogger(DesignationsDao.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(Designations entity) {
		logger.info("saving designations instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		} catch(Exception e){
			logger.error("save failed", e);
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(Designations entity) {
		logger.info("deleting designations instance");
		try {
			entity = entityManager.getReference(Designations.class,entity.getDesignationId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public Designations update(Designations entity) {
		logger.info("updating designations instance");
		try {
			Designations result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Designations findById(Integer id) {
		logger.info("finding Designations instance with id: " + id);
		try {
			Designations instance = entityManager.find(Designations.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Designations> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding Designations instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Designations model where model."
					+ propertyName + "= :propertyValue";

			Query query = entityManager.createQuery(queryString,
					Designations.class);
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
	public List<Designations> findAll(final int... rowStartIdxAndCount) {
		
		logger.info("finding all Designations instances");
		try {
			final String queryString = "select model from Designations model";
			Query query = entityManager.createQuery(queryString,
					Designations.class);
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
	
	@SuppressWarnings("unchecked")
	public List<Designations> isDesignationExist(String designationName,Byte isTeactingStaff){
		logger.info("finding Designation exist");
		try {
			final String queryString = "select model from Designations model where model.designation = :name and model.isTeaching = :isTeaching";
			Query query = entityManager.createQuery(queryString,Designations.class);
			query.setParameter("name", designationName);
			query.setParameter("isTeaching", isTeactingStaff);
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}
	
}
