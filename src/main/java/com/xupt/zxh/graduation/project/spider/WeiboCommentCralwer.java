package com.xupt.zxh.graduation.project.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class WeiboCommentCralwer extends BreadthCrawler {

	String cookie = "";
	
	public WeiboCommentCralwer(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}
	
	@Override
	public HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception {
		HttpRequest httpRequest = new HttpRequest(crawlDatum);
		httpRequest
				.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");
		httpRequest.setCookie(cookie);
		return httpRequest.getResponse();
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		
	}
	
	public static void main(String[] args) {
		WeiboCommentCralwer cralwer = new WeiboCommentCralwer("WeiboCommentCralwer", false);
	}

}
