package com.sumadga.sms.dao;

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

import com.sumadga.sms.dto.ClassSection;
import com.sumadga.sms.dto.Section;
import com.sumadga.sms.dto.StudentClass;
import com.sumadga.sms.dto.TeachingStaffSubject;

@Repository
public class ClassSectionDao {

	private static final Logger logger = Logger.getLogger(ClassSectionDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public void save(ClassSection entity) {
		logger.info("saving ClassSection instance");
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
	public void delete(ClassSection entity) {
		logger.info("deleting ClassSection instance");
		try {
			entity = entityManager.getReference(ClassSection.class,
					entity.getClassSectionId());
			entityManager.remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	public ClassSection update(ClassSection entity) {
		logger.info("updating ClassSection instance");
		try {
			ClassSection result = entityManager.merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public ClassSection findById(Long id) {
		logger.info("finding ClassSection instance with id: " + id);
		try {
			ClassSection instance = entityManager.find(ClassSection.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ClassSection> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding ClassSection instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from ClassSection model where model."
					+ propertyName + "= :propertyValue";

			Query query = entityManager.createQuery(queryString,
					ClassSection.class);
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
	public List<ClassSection> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all ClassSection instances");
		try {
			final String queryString = "select model from ClassSection model";
			Query query = entityManager.createQuery(queryString,
					ClassSection.class);
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

	public boolean isSectionAndClassAlreadyExist(StudentClass studentClass,Section section) {
		
		logger.info("finding TeachingStaffSubject instance with property: teachingStaffId ,property: teachingStaffId , property: subjectId" );
		try {
		
			final String queryString = "select model from ClassSection model where model.section= :section and model.studentClass= :studentClass";

			Query query = entityManager.createQuery(queryString,ClassSection.class);
			query.setParameter("section", section);
			query.setParameter("studentClass", studentClass);
			
			List<ClassSection> classSections = query.getResultList();
			
			return (classSections.size() > 0);
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
		
	}

	public ClassSection getInfoUsingClassAndSection(StudentClass studentClass,
			Section section) {
		logger.info("finding TeachingStaffSubject instance with property: teachingStaffId ,property: teachingStaffId , property: subjectId" );
		try {
		
			final String queryString = "select model from ClassSection model where model.section= :section and model.studentClass= :studentClass";

			Query query = entityManager.createQuery(queryString,ClassSection.class);
			query.setParameter("section", section);
			query.setParameter("studentClass", studentClass);
			
			ClassSection classSection = (ClassSection)query.getSingleResult();
			
			return classSection;
			
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
}
