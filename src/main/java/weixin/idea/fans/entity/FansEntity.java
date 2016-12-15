package weixin.idea.fans.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name = "weixin_fans",schema = "")
@SuppressWarnings("serial")
public class FansEntity extends IdEntity implements java.io.Serializable{
	//值为0时,代表未关注
	private String subscribe;
	//用户昵称
	private String nickname;
	//性别 1 男性 2 女性 0 未知
	private String sex;
	//所在城市
	private String city;
	//所在省份
	private String province;
	//所在国家
	private String country;
	//头像url
	private String headimgurl;
	//关注时间
	private Timestamp subscribetime;
	//公众号id
	private String accountid;
	@Column(name="accountid")
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	@Column(name="subscribe")
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="province")
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name="country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="headimgurl")
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	@Column(name="subscribetime")
	public Timestamp getSubscribetime() {
		return subscribetime;
	}
	public void setSubscribetime(Timestamp subscribetime) {
		this.subscribetime = subscribetime;
	}
	
	
}
