package com.huan.library.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 封装分页信息
 * @author huan
 * @time 2011-3-17 下午01:05:58
 */
public class PageModel<T> {

	private List<T> restleList = new ArrayList<T>(); // 结果集
	private int pageSize; // 每页记录数
	private int pageNo; // 页号
	private Long totalRecords; // 共多少条记录

	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPages() {
		return (int) ((totalRecords + pageSize - 1) / pageSize);
	}

	/**
	 * 首页
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 尾页
	 * @return
	 */
	public int getBottomNo() {
		return getTopPageNo();
	}

	/**
	 * 上一页
	 * @return
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/**
	 * 下一页
	 * @return
	 */
	public int getNextPageNo() {
		if (pageNo >= getBottomNo()) {
			return getBottomNo();
		}
		return pageNo + 1;
	}

	public List<T> getRestleList() {
		return restleList;
	}
	public void setRestleList(List<T> restleList) {
		this.restleList = restleList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
}
