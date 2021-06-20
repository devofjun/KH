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
	
	public PagingDto(int page, int totalCount, int perPage, String searchType, String keyword) {
		this.page = page;				// 요청한 페이지
		this.count = totalCount;		// 전체 게시글 수
		this.perPage = perPage;			// 한 페이지에 보여질 게시글 수
		this.searchType = searchType;	// 검색타입
		this.keyword = keyword;			// 검색 키워드
		
		// 마지막 줄 = 요청한 페이지 * 보여질 페이지수
		this.endRow = page * this.perPage;
		// 첫번째 줄 = 마지막 줄 - 보여질 페이지수 + 1
		this.startRow = endRow - this.perPage + 1;
		// (요청한 페이지-1) => 10 페이지 까지 보이게 하기 위해
		// 1의 자리수 탈락 시키기 위한 식
		this.startPage = ((page-1)/PAGE_BLOCK) * PAGE_BLOCK + 1;
		// 끝 페이지는 시작페이지보다 9크다.
		this.endPage = startPage + PAGE_BLOCK-1;
		// 몇줄씩 보느냐에 달라지는 전체 페이지수(보여질글수의 단위)
		this.totalPage = totalCount / perPage;
		// 전체 페이지수의 단위가 보여질 글수의 단위이기 때문에 나머지 페이지가 있을 경우에 전체페이지수를 1늘린다. 
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
				+ perPage + ", PAGE_BLOCK=" + PAGE_BLOCK + ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}

	

}
