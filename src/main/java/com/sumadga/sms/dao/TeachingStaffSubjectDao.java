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

import com.sumadga.sms.dto.TeachingStaffSubject;

@Repository
public class TeachingStaffSubjectDao {

	private static final Logger logger = Logger.getLogger(TeachingStaffSubjectDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(TeachingStaffSubject entity) {
		logger.info("saving TeachingStaffSubject instance");
		try {
			entityManager.persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void delete(TeachingStaffSubject entity) {
		logger.info("deleting TeachingStaffSubject instance");
		try {
			entity = entityManager.getReference(TeachingStaffSubject.class,
					entity.getTeachingStaffSubjectId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public TeachingStaffSubject update(TeachingStaffSubject entity) {
		logger.info("updating TeachingStaffSubject instance");
		try {
			TeachingStaffSubject result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public TeachingStaffSubject findById(Long id) {
		logger.info("finding TeachingStaffSubject instance with id: " + id);
		try {
			TeachingStaffSubject instance = entityManager.find(TeachingStaffSubject.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TeachingStaffSubject> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding TeachingStaffSubject instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from TeachingStaffSubject model where model."
					+ propertyName + "= :propertyValue";

			Query query = entityManager.createQuery(queryString,
					TeachingStaffSubject.class);
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
	public List<TeachingStaffSubject> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all TeachingStaffSubject instances");
		try {
			final String queryString = "select model from TeachingStaffSubject model";
			Query query = entityManager.createQuery(queryString,
					TeachingStaffSubject.class);
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
