package com.xupt.zxh.graduation.project.spider.parse;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 用于解析单条微博的信息
 * @author 张涛
 */
public class ParseWeiboInfo {
	
	public static WeiboInfo parseWeiboInfo(Element element){
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setWeiboId(element.id());
		String tempId = weiboInfo.getWeiboId().substring(2);
		//获取微博的主题内容
		Elements ctt = element.getElementsByClass("ctt");
		weiboInfo.setWeiboContent(ctt.get(0).text());
		//获取 微博点赞数
		Elements attitude = element.getElementsByAttributeValueStarting("href", "http://weibo.cn/attitude/"+tempId);
		String praiseNum = attitude.get(0).text();
		weiboInfo.setPraiseNum(Integer.parseInt(ParseWeiboInfo.getNum(praiseNum)));
		//获取微博转发数
		Elements repost = element.getElementsByAttributeValueStarting("href", "http://weibo.cn/repost/"+tempId);
		String forwardNum = repost.get(0).text();
		weiboInfo.setForwardNum(Integer.parseInt(ParseWeiboInfo.getNum(praiseNum)));
		//获取微博评论数
		Elements comment = element.getElementsByAttributeValueStarting("href", "http://weibo.cn/comment/"+tempId);
		String commentNum = comment.get(0).text();
		weiboInfo.setCommentNum(Integer.parseInt(ParseWeiboInfo.getNum(praiseNum)));
		Elements elements = element.children();
		Element lastDiv = elements.last();
		Element timeAndWay = lastDiv.getElementsByClass("ct").get(0);
		String[] timeAndWays = timeAndWay.html().split("&nbsp;");
		weiboInfo.setTime(timeAndWays[0]);
		weiboInfo.setReleaseWay(timeAndWays[1]);
		//获取时间和方式
		if(element.toString().indexOf("<span class=\"cmt\">原文转发") != -1){
			weiboInfo.setIsForward(1);
			
			String tempStr = lastDiv.text();
			//获取转发理由
			int sufIndex = tempStr.indexOf("  赞[");
			if(sufIndex>=5){
				weiboInfo.setReasonOfForward(tempStr.substring(5, sufIndex));
			}else{
				weiboInfo.setReasonOfForward(null);
			}
		}else{
			weiboInfo.setIsForward(0);
		}
		if(elements.size() <=1){
			//根据分析，此元素中若有两个div元素的，则表明有图；若只有一个div元素则表示没有图,且是原创
			weiboInfo.setHasPicture(0);
		}else if(elements.size() == 2){
			//两个div，且不是转发微博，则表明有图
			if(weiboInfo.getIsForward() == 0){
				weiboInfo.setHasPicture(1);
			}else{
				//两个div，且是转发微博的，则表明没有图
				weiboInfo.setHasPicture(1);
			}
		}else{
			//这种情况暂时表示，有三个div；即为转发微博且，有图
			weiboInfo.setHasPicture(1);
		}
		return weiboInfo;
	}
	
	/**
	 * 从赞 [10] 转发[2] 评论[0]类似的字符串结构中获取其数量
	 * @param preNnum
	 * @return
	 */
	public static String getNum(String preNnum){
		if(preNnum == null){
			return "0";
		}
		int pre = preNnum.indexOf('[');
		int suf = preNnum.indexOf(']');
		if(pre == -1 || suf == -1 || (pre+1) >= suf){
			return "0";
		}
		String num = preNnum.substring(pre+1,suf);
		return num;
	}

}
