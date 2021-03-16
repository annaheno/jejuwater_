package very.cute.domain;

public class CartVO {
	
	private int cno;
	private String userid;
	private int gno;
	private int cstock;
	private String addDate;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public int getCstock() {
		return cstock;
	}
	public void setCstock(int cstock) {
		this.cstock = cstock;
	}
	@Override
	public String toString() {
		return "CartVO [cno=" + cno + ", userid=" + userid + ", gno=" + gno + ", cstock=" + cstock + ", addDate="
				+ addDate + "]";
	}
}