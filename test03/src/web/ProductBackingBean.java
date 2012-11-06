/**
 * 
 */
package web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;

import service.ProductService;

import entity.Product;
import exception.DAOException;

/**
 * @author MHJ
 * 
 */
public class ProductBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4199480961590708570L;
	private static Logger logger = Logger.getLogger(ProductBackingBean.class);
	private ProductService productService;
	private Product currentProduct;

	private List<SelectItem> universeItem;
	private Long selectedUniverse;
	private List<Product> products;
	private static String actionType = "";
	
	public String createUpdateAction() {
		if (actionType.equalsIgnoreCase("update")) {
			try {
				productService.update(currentProduct);
				actionType = "";
			
				return "listProduct";
			} catch (DAOException e) {
				logger.error(e);
				
			}
		} else if (actionType.equalsIgnoreCase("create")) {
			try {
			
				productService.create(currentProduct);
			
				actionType = "";
				return "listProduct";
			} catch (DAOException e) {
				logger.error(e);
		
			}
		}
		return null;

	}
/*
	public void processFileUpload(FileUploadEvent uploadEvent) {
		InputStream in = new ByteArrayInputStream(uploadEvent.getFile()
				.getContents());
		BufferedImage bImage;
		try {
			bImage = ImageIO.read(in);
			String fileName = new Date().getTime() + ".jpg";
			currentProduct.setPicture(fileName);
			File filePath = new File(Utils.getResourcePath("images", false)
					+ fileName);
			System.out.println(filePath);
			ImageIO.write(bImage, "jpg", filePath);
		} catch (IOException e) {
			logger.error(e);
		}

	}
*/
	public String redirectToUpdateFormAction() {
		actionType = "update";
		return "editProduct";
	}

	public String redirectToCreateFormAction() {
		actionType = "create";
		resetAction();
		return "editProduct";
	}

	public void deleteAction() {
		try {
			productService.delete(currentProduct);
		
		} catch (DAOException e) {
	
			logger.error(e);
		}
	}

	public void resetAction() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().clear();
		actionType = "create";
	}

	/**
	 * @return the productService
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * @param productService
	 *            the productService to set
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * @return the currentProduct
	 */
	public Product getCurrentProduct() {
		return currentProduct;
	}

	/**
	 * @param currentProduct
	 *            the currentProduct to set
	 */
	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}

	/**
	 * @return the universeService
	 */
	
	/**
	 * @return the selectedUniverse
	 */
	public Long getSelectedUniverse() {
		return selectedUniverse;
	}

	/**
	 * @param selectedUniverse
	 *            the selectedUniverse to set
	 */
	public void setSelectedUniverse(Long selectedUniverse) {
		this.selectedUniverse = selectedUniverse;
	}

	/**
	 * @return the universeItem
	 */
	

	/**
	 * @param universeItem
	 *            the universeItem to set
	 */
	public void setUniverseItem(List<SelectItem> universeItem) {
		this.universeItem = universeItem;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		products = new ArrayList<Product>();
		try {
			products.addAll(productService.getAll());
		} catch (DAOException e) {
			logger.error(e);
		}
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the userInfo
	 */
	

}
