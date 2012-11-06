/**
 * 
 */
package dao;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import exception.DAOException;

/**
 * @author MHJ
 *
 */
public interface GenericDAO<T,I> {
	@Transactional
	public void create (T bean);
	@Transactional
	public T retrieveOneByPK(@SuppressWarnings("rawtypes") Class clazz,I pk) throws DAOException;
	@Transactional
	public Collection<T> retrieveAll(@SuppressWarnings("rawtypes") Class clazz) throws DAOException;
	@Transactional
	public Collection<T> retrieveByProperty(@SuppressWarnings("rawtypes") Class clazz, String propertyName, Object propertyValue) throws DAOException;
	@Transactional
	public void update(T bean);
	@SuppressWarnings("rawtypes")
	@Transactional
	public void delete(Class clazz, I id) throws DAOException;
	@Transactional
	public Collection<T> retrieveByProperty2(@SuppressWarnings("rawtypes") Class clazz, String propertyName, Object propertyValue, String propertyName2, Object propertyValue2) throws DAOException;
	@Transactional
	public Collection<T> retrieveByProperty3(@SuppressWarnings("rawtypes") Class clazz, String propertyName, Object propertyValue, String propertyName2, Object propertyValue2, String propertyName3, Object propertyValue3) throws DAOException;
	@Transactional
	public Collection<T> retrieveByProperty4(@SuppressWarnings("rawtypes") Class clazz, String propertyName, Object propertyValue, String propertyName2, Object propertyValue2, String propertyName3, Object propertyValue3, String propertyName4, Object propertyValue4) throws DAOException;
}
	