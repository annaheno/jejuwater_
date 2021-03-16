package very.cute.domain;

import java.util.Date;

public class MemberVO {
	
	private String userid;
	private String userpw;
	private String username;
	private String gender;
	private String zipcode;
	private String address1;
	private String address2;
	private String phone;
	private Date regdate;
	private Date updatedate;
	private int verify;
	private boolean useCookie;
	

	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpw() {
		return userpw;
	}


	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public Date getUpdatedate() {
		return updatedate;
	}


	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}


	public int getVerify() {
		return verify;
	}


	public void setVerify(int verify) {
		this.verify = verify;
	}


	public boolean isUseCookie() {
		return useCookie;
	}


	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", gender=" + gender
				+ ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + ", phone=" + phone
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", verify=" + verify + ", useCookie="
				+ useCookie + "]";
	}
}