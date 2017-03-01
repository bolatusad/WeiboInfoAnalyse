package com.xupt.zxh.graduation.project.bean.account;

public class School {
	
	/**
	 * 学校编号
	 */
	private String schoolNumber;
	
	/**
	 * 学校名字
	 */
	private String schoolName;
	
	/**
	 * 学校所在省份
	 */
	private String schoolProvince;
	
	/**
	 * 学校所在城市
	 */
	private String schoolCity;
	
	/**
	 * 学校总注册量
	 */
	private int totalSignUp;
	
	/**
	 * 学校总人数
	 */
	private int totalStudent;

	public String getSchoolNumber() {
		return schoolNumber;
	}

	public void setSchoolNumber(String schoolNumber) {
		this.schoolNumber = schoolNumber;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolProvince() {
		return schoolProvince;
	}

	public void setSchoolProvince(String schoolProvince) {
		this.schoolProvince = schoolProvince;
	}

	public String getSchoolCity() {
		return schoolCity;
	}

	public void setSchoolCity(String schoolCity) {
		this.schoolCity = schoolCity;
	}

	public int getTotalSignUp() {
		return totalSignUp;
	}

	public void setTotalSignUp(int totalSignUp) {
		this.totalSignUp = totalSignUp;
	}

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	} 
	
	

}
