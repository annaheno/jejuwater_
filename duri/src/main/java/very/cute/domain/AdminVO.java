package very.cute.domain;

import java.util.List;

public class AdminVO {
	
	private int bno;
	private String title;
	private String content;
	private  String regdate;
	private  int viewcnt;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	@Override
	public String toString() {
		return "AdminVO [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", viewcnt=" + viewcnt + "]";
	}

}