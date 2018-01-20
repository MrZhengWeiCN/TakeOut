package edu.zhwei.pojo;

import java.util.List;

public class Shop {

	private List<ShopDetail> list;
	private int totalPrice;
	
	public List<ShopDetail> getList() {
		return list;
	}
	public void setList(List<ShopDetail> list) {
		this.list = list;
	}
	public int getTotalPrice() {
		int localTotoal = 0;
		for (ShopDetail detail : list) {
			localTotoal += detail.getTotalPrice();
		}
		return localTotoal;
	}
}
