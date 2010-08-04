package org.mobile.common.bean;

public class PageBean {

	private int currentPage = 1;

	private int totalPage;

	private int totalRec;

	private int pageRec = 10;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRec() {
		return totalRec;
	}

	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}

	public int getPageRec() {
		return pageRec;
	}

	public void setPageRec(int pageRec) {
		this.pageRec = pageRec;
	}

	public int getStartRow() {
		if (currentPage == 0) {
			currentPage = 1;
		}
		if (pageRec == 0) {
			pageRec = 4;
		}
		return (currentPage - 1) * pageRec;
	}

	public void setPage() {
		if (totalRec % pageRec != 0) {
			totalPage = totalRec / pageRec + 1;
		} else {
			totalPage = totalRec / pageRec;
		}
	}
}
