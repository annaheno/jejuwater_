package very.cute.domain;

public class Criteria {
//	페이징 처리 조건
	private int pageNum; //페이지 번호
	private int amount; // 페이지당 데이터 수
	private String type; // 검색 (제목, 내용, 작성자, 제목+내용 . . .)
	private String keyword; // 검색 키워드
	
	// 기본 생성자
	public Criteria() {
		this(1,10); // 페이지가 뜨자마자 번호가 뜨게 한다.
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
//	get, set
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	// toString
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword + "]";
	}
}