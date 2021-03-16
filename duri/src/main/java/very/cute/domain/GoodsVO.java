package very.cute.domain;

public class GoodsVO {
	
	private int gno;
	private String gname;
	private int price;
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
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
		return "GoodsVO [gno=" + gno + ", gname=" + gname + ", price=" + price + "]";
	}
}