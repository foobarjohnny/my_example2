package ilife.common.model;

import ilife.common.Constants;

public class Paging {

	/*当前页*/
	private int currentPage = 1;
	/*每页显示的条数*/
	private int pageSize = Constants.MAX_PAGE_SIZE;

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
