package yuan.zhang.entity;

import java.util.List;

public class Page {
	// 总页数
	 private int totalPage;
	 // 数据总数;即一共有都少条数据，需要显示）
	 private int totalCount;
	 // 页面大小;即每页显示几条数据
	 private int pageSize;
	 // 当前页的页码
	 private int currentPage;
	 // 实体类集合;如List<Student> students，用来保存当前页面中全部学生的信息
	 private List<Record> records;
	 //用户名
	 private String username;
	
	 public Page() {
		super();
	}
	 
	public Page(int totalPage, int totalCount, int pageSize, int currentPage) {
		super();
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}


	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		totalPage = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize) : this.totalCount / pageSize + 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	 
}
