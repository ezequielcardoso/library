package com.huan.library.web.view;

/**
 * grid 提交请求加载数据的基类
 * @author shuaizhichun
 * @time 2011-3-28 上午01:26:13
 */
public class ExtGridPost implements java.io.Serializable {

	private Integer start;//当前分页开始
	private Integer limit;//当前分页大小
	private Long totalCount;//总条数
	private String dir;//排序的方式
	private String sort;//排序的字段
	private Boolean isPage = true;//是否分页

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(Boolean isPage) {
		this.isPage = isPage;
	}
	
	
	
}
