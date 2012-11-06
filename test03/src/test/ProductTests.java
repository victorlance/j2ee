/**
 * 
 */
package test;

import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.GenericDAO;
import entity.Product;

import exception.DAOException;

/**
 * @author MHJ
 * @version 0.1 
 */
public class ProductTests {
	
	private ApplicationContext ctx;
	private Product product;
	
	private GenericDAO<Product, Long> productDao;

	
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp(){
		String path = "/WebContent/WEB-INF/";
		ctx = new FileSystemXmlApplicationContext(
				new String[] { path + "applicationContext.xml",path + "venteBean.xml" });
		
		product = (Product) ctx.getBean("product");
		productDao = (GenericDAO<Product, Long>) ctx.getBean("genericDAO");
	
	}
	
	@Test
	public void createProductTest(){
		product.setName("voyage à paris");
		product.setDescription("une semaine à paris");
		product.setInitialVoucherNbr(10);
		product.setLink("paris.com");
		product.setMap("map.paris.com");
		product.setLastUpdateDate(new Date());
		product.setNbrVoucherSold(0);
		product.setOrder(1);
		product.setNormalSellingPrice(5000D);
		product.setCreationDate(new Date());
		product.setPicture("paris.jpg");
		product.setReductionRatio(5D);
		product.setVoucherPrice(1000D);
		Product pt=new Product();
		pt.setName("voyage à paris");
		
		productDao.create(pt);
	}
	
	@Test
	public void getProductsTest(){
		try {
			for(Product p: productDao.retrieveAll(Product.class)){
				System.out.println(p.getName());
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateProductTest(){
		try {
			product = productDao.retrieveOneByPK(Product.class, 16L);
			product.setLastUpdateDate(new Date());
			productDao.update(product);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		/*	UserTests t=new UserTests();
			t.setUp();
			t.createUserTest();*/
			
			
		ProductTests p=new ProductTests();
		p.setUp();
		p.createProductTest();
			
		}
}
