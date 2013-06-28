package br.org.guddi.util.searh;

import java.util.Map;

public class SearchFilter {

	private int first, pageSize;
	private String sortField;
	private boolean sortOrder;
	private Map<String, String> filters;

	public SearchFilter() {
		super();
		first = 0;
		pageSize = 10;
		sortOrder = true;
	}

	public SearchFilter(int first, int pageSize) {
		super();
		this.first = first;
		this.pageSize = pageSize;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public boolean getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Map<String, String> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}
}