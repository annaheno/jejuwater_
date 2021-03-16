package very.cute.domain;

public class CartListVO {
	
	private int cno;
	private String userid;
	private int gno;
	private int cstock;
	private String addDate;
	
	private int num;
	private String gname;
	private int price;
	
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartListVO [cno=" + cno + ", userid=" + userid + ", gno=" + gno + ", cstock=" + cstock + ", addDate="
				+ addDate + ", num=" + num + ", gname=" + gname + ", price=" + price + "]";
	}
}