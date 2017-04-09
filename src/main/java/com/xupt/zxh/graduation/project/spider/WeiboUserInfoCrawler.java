package com.xupt.zxh.graduation.project.spider;

import java.net.URLEncoder;
import java.util.HashMap;

import com.xupt.zxh.graduation.project.bean.weibo.WeiboUserInfo;
import com.xupt.zxh.graduation.project.spider.parse.ParseWeiboUserInfo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * 用于爬取指定用户类型的用户信息
 * 
 * @author 张涛 查找校友：http://weibo.cn/find/user?class=school&vt=4
 * 
 */
public class WeiboUserInfoCrawler extends BreadthCrawler {

	private String cookie = "";

	public static final String username = "15240789374";

	public static final String password = "a123456";

	// junit测试类，必须有一个无参的构造方法

	public WeiboUserInfoCrawler(String crawlPath, boolean autoParse)
			throws Exception {
		super(crawlPath, autoParse);
		this.cookie = GetCookie.getCookie(username, password);

	}

	// 重写父类方法，自定义cookie
	@Override
	public HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception {
		HttpRequest httpRequest = new HttpRequest(crawlDatum);
		httpRequest
				.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");
		httpRequest.setCookie(cookie);
		if (crawlDatum.meta("method") != null
				&& crawlDatum.meta("method").equalsIgnoreCase("POST")) {
			httpRequest.setHeader("Referer",
					"http://weibo.cn/find/user?class=school");
			httpRequest.setHeader("Content-type",
					"application/x-www-form-urlencoded");
			httpRequest.setMethod(crawlDatum.meta("method"));
			String outputData = crawlDatum.meta("outputData");
			if (outputData != null) {
				httpRequest.setOutputData(outputData.getBytes("utf-8"));
			}
		}
		return httpRequest.getResponse();
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		Document doc = page.doc();
		// 通过用户列表获取用户主页地址,前面的判断条件是用户post请求的时候，后面的判断条件是用于get请求
		if (page.matchUrl("http://weibo.cn/find/user")
				|| page.matchUrl("http://weibo.cn/find/user\\?scho=.*&gender=0&sschocomp=1&class=school&suser=1&page=.*")) {
			Elements elements = doc.getElementsByTag("table");
			System.out.println("====================================");
			for (Element e : elements) {
				Elements elements2 = e.getElementsByTag("a");
				String url = elements2.get(0).attr("href");
				String urlTab = "http://weibo.cn" + url;
				next.add(urlTab);
				// this.addSeed(urlTab,true);
				System.out.println(urlTab);
			}
			System.out.println("====================================");
			return;
		}

		// 通过用户的详细资料页面，获取用户的详细信息
		if (page.matchUrl("http://weibo.cn/.*/info")) {
			// Elements elements = doc.getElementsByClass("c");
			Elements elements = doc.getElementsByClass("tip");
			WeiboUserInfo userInfo = new WeiboUserInfo();
			for (Element e : elements) {
				String tip = e.text();
				switch (tip) {
				case "基本信息":
					Element essentialInfo = e.nextElementSibling();
					userInfo = ParseWeiboUserInfo.parseEssentialInfo(
							essentialInfo, userInfo);
					break;

				case "学习经历":
					Element studyInfo = e.nextElementSibling();
					userInfo = ParseWeiboUserInfo.parseStudyInfo(studyInfo,
							userInfo);
					break;

				case "工作经历":
					Element workInfo = e.nextElementSibling();
					userInfo = ParseWeiboUserInfo.parseWorkInfo(workInfo,
							userInfo);
					break;

				case "其他信息":
					Element otherInfo = e.nextElementSibling();
					userInfo = ParseWeiboUserInfo.parseOtherInfo(otherInfo,
							userInfo);
					break;

				default:
					break;
				}
			}
			System.out.println(userInfo);
			return;

		}

		// 通过用户主页，获取用户个人资料地址
		if (page.matchUrl("http://weibo.cn/.*")) {
			Elements elements = doc.getElementsByAttributeValueEnding("href",
					"/info");
			if (elements.size() >= 1) {
				String preUrl = elements.get(0).attr("href");
				String url = "http://weibo.cn" + preUrl;
				next.add(url);
				// this.addSeed(url);
				System.out.println(url);
			}
			return;
		}

	}

	/**
	 * 用于测试获取微博搜索的列表，采用的是post的方法，经过测试可以采用get的方法
	 */
	public static void getContent() throws Exception {
		String url = "http://weibo.cn/find/user";
		WeiboUserInfoCrawler crawler = new WeiboUserInfoCrawler("WeiboUserCrawler",
				false);
		HashMap<String, String> params = new HashMap<String, String>();
		// 进行post请求
		// params.put("method", "POST");
		// 添加参数
		// params.put("scho",
		// "%E8%A5%BF%E5%AE%89%E9%82%AE%E7%94%B5%E5%A4%A7%E5%AD%A6");
		// params.put("scho", "西安邮电大学");
		// params.put("keyword", "");
		// params.put("gender", "0");
		// params.put("sschocomp", "1");
		// params.put("class", "school");
		// params.put("suser", "1");
		CrawlDatum crawlDatum = new CrawlDatum(url);
		crawlDatum.setMetaData(params);
		String school = URLEncoder.encode("西安邮电大学", "UTF-8");
		crawler.addSeed(crawlDatum
				.meta("method", "POST")
				.meta("outputData",
						"scho="
								+ school
								+ "&keyword=&gender=0&sschocomp=1&class=school&suser=1"));

		// crawler.addRegex("http://weibo.cn/.*/info");
		// crawler.addRegex("http://weibo.cn/.*");
		// /*不要爬取 jpg|png|gif*/
		// crawler.addRegex("-.*\\.(jpg|png|gif).*");
		// /*不要爬取包含 # 的URL*/
		// crawler.addRegex("-.*#.*");
		crawler.start(4);

	}

	/**
	 * 正式获取用户信息的链接,暂时先测试前5页
	 * 
	 * @throws Exception
	 */
	public static void getContentByGet() throws Exception {
		String school = "西安邮电大学";
		String url = "http://weibo.cn/find/user?scho="
				+ URLEncoder.encode(school, "utf-8")
				+ "&gender=0&sschocomp=1&class=school&suser=1&page=";
		WeiboUserInfoCrawler crawler = new WeiboUserInfoCrawler("WeiboUserCrawler",
				false);
		HashMap<String, String> params = new HashMap<String, String>();
		for (int i = 1; i <= 5; i++) {
			System.out.println("第"+i+"页");
			String seed = url + i;
			crawler.addSeed(seed);
		}
		crawler.start(4);

	}

	public static void main(String[] args) throws Exception {
		WeiboUserInfoCrawler.getContentByGet();
	}

}
