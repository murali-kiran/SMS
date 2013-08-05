package com.sumadga.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sumadga.sms.dto.TeachingStaff;
import com.sumadga.sms.model.GenericBean;

@Repository
public class TeachingStaffDao {

	private static final Logger logger = Logger.getLogger(TeachingStaffDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(TeachingStaff entity) {
		logger.info("saving TeachingStaff instance");
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
	public void delete(TeachingStaff entity) {
		logger.info("deleting TeachingStaff instance");
		try {
			entity = entityManager.getReference(TeachingStaff.class,
					entity.getTeachingStaffId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public TeachingStaff update(TeachingStaff entity) {
		logger.info("updating TeachingStaff instance");
		try {
			TeachingStaff result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public TeachingStaff findById(Long id) {
		
		logger.info("finding TeachingStaff instance with id: " + id);
		try {
			TeachingStaff instance = entityManager.find(TeachingStaff.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TeachingStaff> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding TeachingStaff instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from TeachingStaff model where model."
					+ propertyName + "= :propertyValue";

			Query query = entityManager.createQuery(queryString,
					TeachingStaff.class);
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
	public List<TeachingStaff> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all TeachingStaff instances");
		try {
			final String queryString = "select model from TeachingStaff model";
			Query query = entityManager.createQuery(queryString,
					TeachingStaff.class);
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
	public List<GenericBean> findAllTeachingStaffByNativeQuery() {
		logger.info("finding all TeachingStaff instances");
		try {
			final String queryString = "SELECT t.staffId as id,s.name as name FROM TeachingStaff  t join Staff s on t.staffId = s.staffId";
			Query query = entityManager.createNativeQuery(queryString);
			List<Object[]> list = query.getResultList();
			List<GenericBean> genericBeans = new ArrayList<GenericBean>();
			for(Object[] obj : list){
				GenericBean bean = new GenericBean();
				bean.setId((Integer)obj[0]);
				bean.setName((String)obj[1]);
				genericBeans.add(bean);
			}
			return genericBeans;
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}
	
	
}
