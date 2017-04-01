package com.xupt.zxh.graduation.project.spider.bean;

/**
 * 用于绑定从微博上采集到的用户的信息
 * @author 张涛
 *
 */
public class WeiboUserInfo {
	/**
	 * 微博的用户ID
	 */
	private String userId;
	
	/**
	 * 用户昵称
	 */
	private String nickname;
	
	/**
	 * 认证
	 */
	private String authentication;
	
	/**
	 * 达人 标签
	 */
	private String intelligent;
	
	/**
	 * 用户性别
	 */
	private String gender;
	
	/**
	 * 用户省份
	 */
	private String province;
	
	/**
	 * 用户城市
	 */
	private String city;
	
	/**
	 * 用户生日
	 */
	private String birthday;
	
	/**
	 * 用户性取向
	 */
	private String seaxualOrientation;
	
	/**
	 * 感情状况
	 */
	private String emotional;
	
	/**
	 * 用户认证信息
	 */
	private String authenticationInfo;
	
	/**
	 * 简介
	 */
	private String brief;
	
	/**
	 * 用户标签
	 */
	private String tags;
	
	/**
	 * 学校，暂时只提取第一个
	 */
	private String school;
	
	/**
	 * 入学时间
	 */
	private String schoolTime;
	
	/**
	 * 工作经历
	 */
	private String works;
	
	/**
	 * 用户主页,暂时保存手机界面
	 */
	private String homepage;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIntelligent() {
		return intelligent;
	}

	public void setIntelligent(String intelligent) {
		this.intelligent = intelligent;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSeaxualOrientation() {
		return seaxualOrientation;
	}

	public void setSeaxualOrientation(String seaxualOrientation) {
		this.seaxualOrientation = seaxualOrientation;
	}

	public String getEmotional() {
		return emotional;
	}

	public void setEmotional(String emotional) {
		this.emotional = emotional;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchoolTime() {
		return schoolTime;
	}

	public void setSchoolTime(String schoolTime) {
		this.schoolTime = schoolTime;
	}

	public String getWorks() {
		return works;
	}

	public void setWorks(String works) {
		this.works = works;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getAuthenticationInfo() {
		return authenticationInfo;
	}

	public void setAuthenticationInfo(String authenticationInfo) {
		this.authenticationInfo = authenticationInfo;
	}

	@Override
	public String toString() {
		return "WeiboUserInfo [userId=" + userId + ", nickname=" + nickname
				+ ", authentication=" + authentication + ", intelligent="
				+ intelligent + ", gender=" + gender + ", province=" + province
				+ ", city=" + city + ", birthday=" + birthday
				+ ", seaxualOrientation=" + seaxualOrientation + ", emotional="
				+ emotional + ", authenticationInfo=" + authenticationInfo
				+ ", brief=" + brief + ", tags=" + tags + ", school=" + school
				+ ", schoolTime=" + schoolTime + ", works=" + works
				+ ", homepage=" + homepage + "]";
	}
	
	
	
	
	
}
