/**
 * 
 */
package serviceImpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GenericDAO;
import entity.Product;

import exception.DAOException;
import service.ProductService;


@Service(value="productService")
public class ProductServiceImpl implements ProductService, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4153661835995641058L;
	/**
	 * 
	 */
	@Autowired
	private GenericDAO<Product, Long> produitDAO;
	
	@Override
	public void create(Product product) throws DAOException {
		
		product.setCreationDate(new Date());
		produitDAO.create(product);
	}
	/* (non-Javadoc)
	 * @see disco.couponqweez.service.ProductService#getAll()
	 */
	@Override
	public Collection<Product> getAll() throws DAOException {
		return  produitDAO.retrieveAll(Product.class);
	}
	
	
	
	/* (non-Javadoc)
	 * @see disco.couponqweez.service.ProductService#update(disco.couponqweez.entity.Product, java.lang.Long)
	 */
	@Override
	public void update(Product product) throws DAOException {
	
		produitDAO.update(product);
	}
	/* (non-Javadoc)
	 * @see disco.couponqweez.service.ProductService#delete(disco.couponqweez.entity.Product)
	 */
	@Override
	public void delete(Product product) throws DAOException {
		produitDAO.delete(Product.class, product.getId());
	}
	@Override
	public Product getById(Long id) throws DAOException {
		return produitDAO.retrieveOneByPK(Product.class, id);
	}
	
}
