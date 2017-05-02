package entity;

import java.util.Date;

public class Graduate {
	private String id;
	private int ticketnum;
	private String name;
	private String pwd;
	private String sex;
	private Date birth;
	private String major;
	private String tel;
	private String remark;
	private String tutor1;
	private String tutor2;
	private String tutor3;
	private String chosen;
	private String Ftutor;

	public String getFtutor() {
		return Ftutor;
	}

	public void setFtutor(String ftutor) {
		Ftutor = ftutor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(int ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTutor1() {
		return tutor1;
	}

	public void setTutor1(String tutor1) {
		this.tutor1 = tutor1;
	}

	public String getTutor2() {
		return tutor2;
	}

	public void setTutor2(String tutor2) {
		this.tutor2 = tutor2;
	}

	public String getTutor3() {
		return tutor3;
	}

	public void setTutor3(String tutor3) {
		this.tutor3 = tutor3;
	}

	public String getChosen() {
		return chosen;
	}

	public void setChosen(String chosen) {
		this.chosen = chosen;
	}

}
