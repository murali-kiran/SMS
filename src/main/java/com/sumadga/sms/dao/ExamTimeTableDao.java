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

import com.sumadga.sms.dto.ExamTimeTable;

@Repository
public class ExamTimeTableDao {

	private static final Logger logger = Logger.getLogger(ExamTimeTableDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(ExamTimeTable entity) {
		logger.info("saving ExamTimeTable instance");
		try {
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

			Query query = entityManager.createQuery(queryString,
					ExamTimeTable.class);
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