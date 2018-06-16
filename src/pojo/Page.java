package pojo;

import java.util.List;

public class Page {
	private int rowCount;//每页总条数
	private int pageSize=1;//页面大小
	private int pageNow;//当前页
	private int pageCount;//总页数
	private List list;//每一页的内容
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		setPageCount();
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setPageCount();
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow=pageNow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount() {
		this.pageCount = 
				this.rowCount%this.pageSize==0?
				this.rowCount/this.pageSize:
				this.rowCount/this.pageSize+1;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	} 
	
}
