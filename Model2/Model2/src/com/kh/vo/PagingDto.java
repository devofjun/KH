package com.kh.vo;

public class PagingDto {
	private int page = 1;
	private int startRow = 1;
	private int endRow = 10;
	private int count;
	private int startPage;
	private int endPage;
	private int totalPage;
	
	public PagingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PagingDto(int page) {
		this.page = page;
		this.endRow = page * 10;
		this.startRow = endRow - 9;
		/*
		if(page % 10 == 0) {
			this.endPage = ((int)(page/10))*10;
		} else {
			this.endPage = ((int)(page/10)+1)*10;
		}
		this.startPage = endPage - 9;
		*/
		this.startPage = ((page-1)/10) * 10 + 1;
		this.endPage = startPage + 9;
	}
	
	public PagingDto(int page, int totalCount) {
		this.page = page;
		this.startPage = ((page-1)/10) * 10 + 1;
		this.endPage = startPage + 9;
		//this.totalPage = (totalCount / 10) + ((totalCount) % 10)
		this.totalPage = totalCount / 10;
		if(totalCount % 10 != 0) {
			this.totalPage += 1;
		}
	}
	
	public PagingDto(int page, int startRow, int endRow, int count) {
		super();
		this.page = page;
		this.startRow = startRow;
		this.endRow = endRow;
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", startRow=" + startRow + ", endRow=" + endRow + ", count=" + count
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
	}

}
