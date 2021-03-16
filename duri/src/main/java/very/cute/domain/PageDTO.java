package very.cute.domain;

public class PageDTO {
//첫번째 페이지
	private int startPage;
//	마지막 페이지
	private int endPage;
// 이전 페이지, 다음 페이지 여부
	private boolean prev,next;
//	게시물 총 갯수
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
//		endPage 계산식
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
//		startPage 계산식
		this.startPage=this.endPage-9;
		
//		진짜 마지막 페이지 계산식
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
//		1 페이지 앞에는 prev 버튼 제외, 11 페이지부터 생성
		if(realEnd < endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1; //1>1=false 값이니 보여주지 않겠다. 11>1은 true 라서 보여줌.
		this.next=this.endPage<realEnd; // 마지막 페이지보다 진짜 마지막 페이지가 더 많아야 보인다. 뭔가 더 있으니 (값이 더 크니까) 계속 보이게 한다.
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
}