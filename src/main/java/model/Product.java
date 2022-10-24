package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{
	
	private int pId;
	private String pName;
	private String pPrice;
		
	public Product() {
		pId = 0;
		pName = "";
		pPrice = "";
	}
	public Product(int pId, String pName, String pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + "]";
	}
}
