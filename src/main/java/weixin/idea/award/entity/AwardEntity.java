package weixin.idea.award.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "weixin_award",schema = "")
@SuppressWarnings("serial")
public class AwardEntity implements java.io.Serializable{
	
	/**主键id**/
	private String id;
	/**奖品名称**/
	private String name;
	/**奖品数量**/
	private Integer number;
	/**奖品价格**/
	private Double price;
	/**奖品等级**/
	private String level;
	/**奖品描述**/
	private String description;
	/**微信公众帐号ID**/
	private String accountid;
	
	@Column(name ="ACCOUNTID",nullable=true,length=100)
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=100)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name ="NAME",nullable=true,length=255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name ="NUMBER",nullable=true,length=100)
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Column(name ="PRICE",nullable=true,length=100)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Column(name ="LEVEL",nullable=true,length=255)
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name ="DESCRIPTION",nullable=true,length=255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
