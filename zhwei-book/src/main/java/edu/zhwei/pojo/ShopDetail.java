package edu.zhwei.pojo;

public class ShopDetail extends Menu{

	private int num;
	private int totalPrice;
	private String remark;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	//获得条目总价格
	public int getTotalPrice() {
		return num*this.getMenuPrice();
	}
	
}
