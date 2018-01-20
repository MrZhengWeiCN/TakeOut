package edu.zhwei.coupon.common;

import java.util.List;

public class PageOpt {

	public static final int INDEX = 16;
	public static final int INDEX_TYPE = 16;
	public static final int SHOP = 10;
	public static final int ORDER_LIST = 10;

	/**
	 * 返回分页结果
	 * 
	 * @param list
	 * @param page
	 * @param pageNum
	 * @return
	 */
	public static List pageList(List list, int page, int pageNum) {
		int size = list.size();
		if (page * pageNum > size)
			list = list.subList((page - 1) * pageNum, size);
		else
			list = list.subList((page - 1) * pageNum, page * pageNum);
		return list;
	}

	/**
	 * 返回分页总页数
	 * 
	 * @return
	 */
	public static int pageRecord(List list, int pageNum) {
		int size = list.size();
		int endPage = size / pageNum + (size % pageNum > 0 ? 1 : 0);
		return endPage;
	}
}
