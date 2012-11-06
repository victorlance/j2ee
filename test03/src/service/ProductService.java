/**
 * 
 */
package service;

import java.util.Collection;

import entity.Product;
import exception.DAOException;


public interface ProductService {
	public void create(Product product)throws DAOException;
	public Collection<Product> getAll()throws DAOException;
	public Product getById(Long id)throws DAOException;
	public void update(Product product)throws DAOException;
	public void delete(Product product)throws DAOException;
}
