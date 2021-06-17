package com.kh.vo;

public class PagingDto {
	private int page = 1;
	private int startRow = 1;
	private int endRow = 10;
	private int count;
	private int startPage;
	private int endPage;
	private int totalPage;
	private int perPage;
	private final int PAGE_BLOCK = 10;
	// 검색 관련 변수임. 따로 dto로 만들어도됨
	private String searchType;
	private String keyword;
	
	
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
		this.startPage = ((page-1)/PAGE_BLOCK) * PAGE_BLOCK + 1;
		this.endPage = startPage + PAGE_BLOCK-1;
	}
	
	public PagingDto(int page, int totalCount, int perPage) {
		this.page = page;
		this.count = totalCount;
		this.perPage = perPage;
		
		this.endRow = page * this.perPage;
		this.startRow = endRow - this.perPage;
		this.startPage = ((page-1)/PAGE_BLOCK) * PAGE_BLOCK + 1;
		this.endPage = startPage + PAGE_BLOCK-1;
		//this.totalPage = (totalCount / 10) + ((totalCount) % 10)
		// 몇줄씩 보느냐에 달라지는 페이지수
		this.totalPage = totalCount / perPage;
		if(totalCount % perPage != 0) {
			this.totalPage += 1;
		}
		// 끝페이지가 최대 페이지를 넘지 않도록
		if(this.endPage > totalPage) {
			this.endPage = this.totalPage;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", startRow=" + startRow + ", endRow=" + endRow + ", count=" + count
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", totalPage=" + totalPage + ", perPage="
				+ perPage + ", PAGE_BLOCK=" + PAGE_BLOCK + "]";
	}

}
