package br.org.guddi.util.search;

import java.util.Collections;
import java.util.Map;

public class SearchFilter {

	private int first, pageSize;
	private String sortField;
	private boolean sortOrder;
	private Map<String, String> filters;

	/**
     *
     */
    public SearchFilter() {
		super();
		first = 0;
		pageSize = 10;
		sortOrder = true;
	}

	/**
     *
     * @param first
     * @param pageSize
     */
    public SearchFilter(int first, int pageSize) {
		super();
		this.first = first;
		this.pageSize = pageSize;
	}

	/**
     *
     * @return
     */
    public int getFirst() {
		return first;
	}

	/**
     *
     * @param first
     */
    public void setFirst(int first) {
		this.first = first;
	}

	/**
     *
     * @return
     */
    public int getPageSize() {
		return pageSize;
	}

	/**
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
     *
     * @return
     */
    public String getSortField() {
		return sortField;
	}

	/**
     *
     * @param sortField
     */
    public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	/**
     *
     * @return
     */
    public boolean getSortOrder() {
		return sortOrder;
	}

	/**
     *
     * @param sortOrder
     */
    public void setSortOrder(boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
     *
     * @return
     */
    public Map<String, String> getFilters() {
		return Collections.unmodifiableMap(filters);
	}

	/**
     *
     * @param filters
     */
    public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

}