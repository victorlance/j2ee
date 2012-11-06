/**
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7212164345604022043L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="LINK")
	private String link;
	@Column(name="MAP")
	private String map;
	@Column(name="VIDEO")
	private String video;
	@Column(name="PICTURE")
	private String picture;
	@Column(name="PRODUCT_ORDER")
	private Integer order;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATION_DATE")
	private Date creationDate;
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	@Column(name="INITIAL_VOUCHER_NBR")
	private Integer initialVoucherNbr;
	@Column(name="NBR_VOUCHER_SOLD")
	private Integer nbrVoucherSold;
	@Column(name="VOUCHER_PRICE")
	private Double voucherPrice;
	@Column(name="NORMAL_SELLING_PRICE")
	private Double normalSellingPrice;
	@Column(name="REDUCTION_RATIO")
	private Double reductionRatio;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the map
	 */
	public String getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public void setMap(String map) {
		this.map = map;
	}
	/**
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	/**
	 * @return the initialVoucherNbr
	 */
	public Integer getInitialVoucherNbr() {
		return initialVoucherNbr;
	}
	/**
	 * @param initialVoucherNbr the initialVoucherNbr to set
	 */
	public void setInitialVoucherNbr(Integer initialVoucherNbr) {
		this.initialVoucherNbr = initialVoucherNbr;
	}
	/**
	 * @return the nbrVoucherSold
	 */
	public Integer getNbrVoucherSold() {
		return nbrVoucherSold;
	}
	/**
	 * @param nbrVoucherSold the nbrVoucherSold to set
	 */
	public void setNbrVoucherSold(Integer nbrVoucherSold) {
		this.nbrVoucherSold = nbrVoucherSold;
	}
	/**
	 * @return the voucherPrice
	 */
	public Double getVoucherPrice() {
		return voucherPrice;
	}
	/**
	 * @param voucherPrice the voucherPrice to set
	 */
	public void setVoucherPrice(Double voucherPrice) {
		this.voucherPrice = voucherPrice;
	}
	/**
	 * @return the normalSellingPrice
	 */
	public Double getNormalSellingPrice() {
		return normalSellingPrice;
	}
	/**
	 * @param normalSellingPrice the normalSellingPrice to set
	 */
	public void setNormalSellingPrice(Double normalSellingPrice) {
		this.normalSellingPrice = normalSellingPrice;
	}
	/**
	 * @return the reductionRatio
	 */
	public Double getReductionRatio() {
		return reductionRatio;
	}
	/**
	 * @param reductionRatio the reductionRatio to set
	 */
	public void setReductionRatio(Double reductionRatio) {
		this.reductionRatio = reductionRatio;
	}
	/**
	 * @return the universe
	 */
	
}
