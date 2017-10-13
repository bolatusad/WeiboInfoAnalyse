package com.xupt.zxh.graduation.project.spider.parse;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 用于从html中解析出微博用户的信息
 * 
 * @author 张涛
 * 
 */
public class ParseWeiboUserInfo {

	/**
	 * 解析基本信息
	 * 
	 * @param e
	 */
	public static WeiboUserInfo parseEssentialInfo(Element e,
			WeiboUserInfo userInfo) {
		// 填充标签
		Elements tags = e.getElementsByTag("a");
		String tag = "";
		for (Element element : tags) {
			if (!"更多>>".equals(element.text().trim())) {
				tag += element.text() + ",";
			}
		}
		if (tag.length() > 0) {
			userInfo.setTags(tag.substring(0, tag.length() - 1));
		}
		// 填充其它基本信息
		String content = e.html().trim();
		String[] preUserInfos = content.split("<br>");
		for (int i = 0; i < preUserInfos.length; i++) {
			String[] temps = preUserInfos[i].split(":");
			if (temps.length < 2) {
				temps = preUserInfos[i].split("：");
			}
			if (temps.length >= 2) {
				switch (temps[0].trim()) {
				case "昵称":
					userInfo.setNickname(temps[1]);
					break;
				case "认证":
					userInfo.setAuthentication(temps[1]);
					break;
				case "达人":
					userInfo.setIntelligent(temps[1]);
					break;
				case "性别":
					userInfo.setGender(temps[1]);
					break;
				case "地区":
					userInfo.setProvince(temps[1]);
					break;
				case "生日":
					userInfo.setBirthday(temps[1]);
					break;
				case "性取向":
					userInfo.setSeaxualOrientation(temps[1]);
					break;
				case "感情状况":
					userInfo.setEmotional(temps[1]);
					break;
				case "认证信息":
					userInfo.setAuthenticationInfo(temps[1]);
					break;
				case "简介":
					userInfo.setBrief(temps[1]);
					break;
				// 剩下的暂时什么也不做
				default:
					break;
				}
			}
		}
		return userInfo;
	}

	/**
	 * 解析学习经历
	 * 
	 * @param e
	 */
	public static WeiboUserInfo parseStudyInfo(Element e, WeiboUserInfo userInfo) {
		String studyInfo = e.html().trim();
		String[] studyInfos = studyInfo.split("<br>");
		for (int i = 0; i < studyInfos.length; i++) {
			// 暂时只是西安邮电大学
			if (studyInfos[i].indexOf("西安邮电") != -1) {
				String[] temps = studyInfos[i].split("&nbsp;");
//				userInfo.setSchool(temps[0].substring(1));
				if (temps.length >= 2) {
					userInfo.setSchoolTime(temps[1].trim().substring(0,
							temps[1].length() - 1));
				}
				break;
			}
		}
		return userInfo;
	}

	/**
	 * 解析工作经历
	 * 
	 * @param e
	 */
	public static WeiboUserInfo parseWorkInfo(Element e, WeiboUserInfo userInfo) {
		String studyInfo = e.html().trim().replaceAll("&nbsp;", " ");
		String[] studyInfos = studyInfo.split("<br>");
		String workInfo = "";
		for (int i = 0; i < studyInfos.length; i++) {
			workInfo += studyInfos[i].substring(1)+",";
		}
		userInfo.setWorks(workInfo.substring(0,workInfo.length()-1));
		return userInfo;
	}

	/**
	 * 解析其它信息
	 * 
	 * @param e
	 */
	public static WeiboUserInfo parseOtherInfo(Element e, WeiboUserInfo userInfo) {
		String otherInfo = e.html().trim();
		String[] otherInfos = otherInfo.split("<br>");
		for(int i = 0;i<otherInfos.length;i++){
			if(otherInfos[i].indexOf("手机版") != -1){
				String homePage = otherInfos[i].substring(otherInfos[i].indexOf(':')+1);
				userInfo.setHomepage(homePage);
//				userInfo.setUserId(homePage.substring(16));
			}
		}
		return userInfo;
	}

}
