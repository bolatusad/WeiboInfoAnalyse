package com.xupt.zxh.graduation.project.bean.account;

import java.util.Date;

public class User {

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 邮箱，当做用户名
	 */
	private String email;
	
	/**
	 * 用户昵称
	 */
	private String nickname;
	
	/**
	 * 账户密码
	 */
	private String password;
	
	/**
	 * 用户手机号
	 */
	private String phone;
	
	/**
	 * 用户类型：1：普通学生；2：管理员
	 */
	private Integer type;
	
	/**
	 * 用户创建时间
	 */
	private Date createTime;
	
	/**
	 * 账户是否被激活；0：未激活；1：激活
	 */
	private Integer active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
}
