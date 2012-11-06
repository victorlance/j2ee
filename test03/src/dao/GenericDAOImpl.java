/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


import exception.DAOException;

/**
 * @author MHJ
 * 
 */
@Repository(value = "genericDAO")
public class GenericDAOImpl<T, I> implements GenericDAO<T, I>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 384696016904078997L;
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.deptcollection.dao.IDAO#create(java.lang.Object)
	 */
	@Override
	public void create(T bean) {
		entityManager.persist(bean);
		//entityManager.merge(bean);
	}
	
	/* (non-Javadoc)
	 * @see disco.couponqweez.dao.GenericDAO#retrieveOneByPK(java.lang.Class, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T retrieveOneByPK(@SuppressWarnings("rawtypes") Class clazz, I pk) throws DAOException{
		T bean = (T) entityManager.find(clazz, pk);
		if(bean.equals(null)){
			throw new DAOException("no entity type  is found");
		}else{
			return bean;
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.deptcollection.dao.GenericDAO#retrieveAll(java.lang.Class)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<T> retrieveAll(Class clazz) throws DAOException   {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder
				.createQuery();
		Root from = criteriaQuery.from(clazz);
		CriteriaQuery<T> select = criteriaQuery.select(from);
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		if (typedQuery.getResultList().isEmpty()) {
			throw new DAOException("no entity type "+clazz.getCanonicalName()+" is found");
		} else {
			return typedQuery.getResultList();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.deptcollection.dao.IDAO#update(java.lang.Object)
	 */
	@Override
	public void update(T bean) {
			entityManager.merge(bean);
	}

	/* (non-Javadoc)
	 * @see org.deptcollection.dao.GenericDAO#delete(java.lang.Class, java.lang.Object)
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public void delete(Class clazz, I id) throws DAOException {
			Collection<T> bean = this.retrieveByProperty(clazz, "id", id);
			Iterator<T> itBean = bean.iterator();
			entityManager.remove(itBean.next());	
	}

	/* (non-Javadoc)
	 * @see org.deptcollection.dao.GenericDAO#retrieveByProperty(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> retrieveByProperty(Class clazz, String propertyName,
			Object propertyValue) throws DAOException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery();
		Root from = criteriaQuery.from(clazz);
		CriteriaQuery<T> select = criteriaQuery.select(from);
		Predicate predicate =criteriaBuilder.conjunction();

		if(propertyValue instanceof Long || propertyValue instanceof Integer || propertyValue instanceof Double || propertyValue instanceof Float){
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(from.get(propertyName), propertyValue));
		}else{
			Expression<String> literal = criteriaBuilder.upper(criteriaBuilder.literal((String) propertyValue));
			predicate = criteriaBuilder.like(criteriaBuilder.upper(from.get(propertyName)), literal);
		}
		criteriaQuery.where(predicate);		
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		if (typedQuery.getResultList().isEmpty()) {
			throw new DAOException("no entity type "+clazz.getCanonicalName()+" is found");
		} else {
			return typedQuery.getResultList();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> retrieveByProperty2(Class clazz, String propertyName,
			Object propertyValue, String propertyName2,
			Object propertyValue2) throws DAOException {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery();
		Root from = criteriaQuery.from(clazz);
		CriteriaQuery<T> select = criteriaQuery.select(from);
		Predicate predicate =criteriaBuilder.conjunction();

		if(propertyValue instanceof Long || propertyValue instanceof Integer || propertyValue instanceof Double || propertyValue instanceof Float){
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(from.get(propertyName), propertyValue),criteriaBuilder.equal(from.get(propertyName2), propertyValue2));
		}else{
			Expression<String> literal = criteriaBuilder.upper(criteriaBuilder.literal((String) propertyValue));
			predicate = criteriaBuilder.like(criteriaBuilder.upper(from.get(propertyName)), literal);
		}
		criteriaQuery.where(predicate);		
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		if (typedQuery.getResultList().isEmpty()) {
			throw new DAOException("no entity type "+clazz.getCanonicalName()+" is found");
		} else {
			return typedQuery.getResultList();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> retrieveByProperty3(Class clazz, String propertyName,
			Object propertyValue, String propertyName2, Object propertyValue2,
			String propertyName3, Object propertyValue3) throws DAOException {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery();
		Root from = criteriaQuery.from(clazz);
		CriteriaQuery<T> select = criteriaQuery.select(from);
		Predicate predicate =criteriaBuilder.conjunction();

		if(propertyValue instanceof Long || propertyValue instanceof Integer || propertyValue instanceof Double || propertyValue instanceof Float||propertyValue3 instanceof Float){
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(from.get(propertyName), propertyValue),criteriaBuilder.equal(from.get(propertyName2), propertyValue2),criteriaBuilder.equal(from.get(propertyName3), propertyValue3));
		}else{
			//Expression<String> literal = criteriaBuilder.upper(criteriaBuilder.literal((String) propertyValue));
			Expression<String> literal1 = criteriaBuilder.upper(criteriaBuilder.literal((String) propertyValue3));
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(from.get(propertyName), propertyValue),criteriaBuilder.equal(from.get(propertyName2), propertyValue2),criteriaBuilder.equal(from.get(propertyName3), literal1));
		}
		criteriaQuery.where(predicate);		
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		if (typedQuery.getResultList().isEmpty()) {
			throw new DAOException("no entity type "+clazz.getCanonicalName()+" is found");
		} else {
			return typedQuery.getResultList();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> retrieveByProperty4(Class clazz, String propertyName,
			Object propertyValue, String propertyName2, Object propertyValue2,
			String propertyName3, Object propertyValue3, String propertyName4,
			Object propertyValue4) throws DAOException {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery();
		Root from = criteriaQuery.from(clazz);
		CriteriaQuery<T> select = criteriaQuery.select(from);
		Predicate predicate =criteriaBuilder.conjunction();
		
		/*
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root e = cq.from(Fiche.class);*/
		Join a = from.join("utulisateur");
		//criteriaQuery.where(criteriaBuilder.equal(a.get("id"), propertyValue4));
		
		if(propertyValue instanceof Long || propertyValue instanceof Integer || propertyValue instanceof Double || propertyValue instanceof Float||propertyValue3 instanceof Float){
			//predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(from.get(propertyName), propertyValue),criteriaBuilder.equal(from.get(propertyName2), propertyValue2),criteriaBuilder.equal(from.get(propertyName3), propertyValue3),criteriaBuilder.equal(from.get(propertyName4), propertyValue4));
		}else{
			//Expression<String> literal = criteriaBuilder.upper(criteriaBuilder.literal((String) propertyValue));
			Expression<String> literal1 = criteriaBuilder.upper(criteriaBuilder.literal((String) propertyValue3));
		predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(from.get(propertyName), propertyValue),criteriaBuilder.equal(from.get(propertyName2), propertyValue2),criteriaBuilder.equal(from.get(propertyName3), literal1),criteriaBuilder.equal(a.get("id"), propertyValue4));
		
		}
		criteriaQuery.where(predicate);		
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		if (typedQuery.getResultList().isEmpty()) {
			throw new DAOException("no entity type "+clazz.getCanonicalName()+" is found");
		} else {
			return typedQuery.getResultList();
		}
	}

	

	
}
