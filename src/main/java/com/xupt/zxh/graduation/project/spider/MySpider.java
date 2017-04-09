package com.xupt.zxh.graduation.project.spider;

import com.alibaba.fastjson.JSON;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import com.xupt.zxh.graduation.project.spider.Util.MyPage;
import com.xupt.zxh.graduation.project.spider.parse.ParseWeiboInfo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by admin on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)//使用Junit4进行测试
//@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {"classpath:spring/spring-applicationContext.xml"})//加载配置文件classpath:spring/applicationContext.xml
public class MySpider {

    @Autowired
    private IWeiboInfoService weiboInfoService;

    /**
     * 页面的队列
     */
    private Queue<MyPage> myPageQueue;

    /**
     * 存放页面的URL
     */
    private Queue<String> pages;

    /**
     * 获取微博信息并返回符合条件的url
     * @param url
     */
    public void getWeiboInfo(String url) throws IOException, InterruptedException {
        List<String> urls = new ArrayList<String>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String cookie = "_T_WM=f5b5b303e9f3d6629d1bde497de0cc38; " +
                "SUB=_2AkMvuQY9dcPxrAVRn_0SzmrqbYlH-jycbG_LAn7oJhMyPRgv7k4WqScU1AK--1uWSHiyMEv_cvZkJ4ODgQ..; " +
                "PHPSESSID=5e7eada18dda1d1499c8cbfe387b82eb";
        httpGet.setHeader("Host","weibo.cn");
        httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.setHeader("Accept-Encoding","gzip, deflate");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");
        httpGet.setHeader("Cookie", cookie);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        MyPage myPage = new MyPage();
        myPage.setUrl(url);
        Document document = Jsoup.parse(EntityUtils.toString(httpEntity));
        myPage.setDocument(document);
        parseWeiboInfo(myPage);
        //暂停5秒
        Thread.sleep(5000);
        //判断是否有下一页的链接，若有添加到next中，若没有则什么也不做
        Element preNextPage = document.getElementById("pagelist");
        Elements next = preNextPage.getElementsByTag("a");
//        Elements nextPage = preNextPage.getElementsByAttributeValueContaining("href", "?page=");
        if(next.size()>0 && "下页".equals(next.get(0).text().trim())){
            String nextPageUrl = "http://weibo.cn"+next.get(0).attr("href");
            System.out.println(nextPageUrl);
            getWeiboInfo(nextPageUrl);
        }
    }

    /**
     * 访问页面
     */
    public void visitPage() throws IOException {
        while (!pages.isEmpty()){
            String url = pages.remove();
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            String cookie = "_T_WM=f5b5b303e9f3d6629d1bde497de0cc38; " +
                    "SUB=_2AkMvuQY9dcPxrAVRn_0SzmrqbYlH-jycbG_LAn7oJhMyPRgv7k4WqScU1AK--1uWSHiyMEv_cvZkJ4ODgQ..; " +
                    "PHPSESSID=5e7eada18dda1d1499c8cbfe387b82eb";
            httpGet.setHeader("Host","weibo.cn");
            httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            httpGet.setHeader("Accept-Encoding","gzip, deflate");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");
            httpGet.setHeader("Cookie", cookie);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            MyPage myPage = new MyPage();
            myPage.setUrl(url);
            myPage.setDocument(Jsoup.parse(EntityUtils.toString(httpEntity)));
            parseWeiboInfo(myPage);
            myPageQueue.add(myPage);
        }

    }



    /**
     * 用于解析页面中的微博信息
     * @param myPage
     * @return
     */
    public List<WeiboInfo> parseWeiboInfo(MyPage myPage) throws UnsupportedEncodingException {
        List<WeiboInfo> weiboInfos = new ArrayList<WeiboInfo>();
        Document document = myPage.getDocument();
        Elements elements = document.getElementsByClass("c");
        for(Element e : elements){
            if(e.id() != null && !"".equals(e.id())){
                WeiboInfo weiboInfo = ParseWeiboInfo.parseWeiboInfo(e);
                String url = myPage.getUrl();
                int sufIndex = url.indexOf("?page");
                if(sufIndex == -1){
                    weiboInfo.setWeiboAuthor(myPage.getUrl().substring(16));
                }else{
                    weiboInfo.setWeiboAuthor(myPage.getUrl().substring(16,sufIndex));
                }
                weiboInfos.add(weiboInfo);
//                System.out.println(weiboInfo.getReasonOfForward().getBytes("utf-8"));

                System.out.println(weiboInfo);
                weiboInfoService.insertWeiboInfo(weiboInfo);
            }
        }
        return weiboInfos;
    }

    @Test
    public void myWeiboInfo() throws IOException, InterruptedException {
        String url = "http://weibo.cn/u/1984666617";
//        String url = "http://weibo.cn/u/2143272275";
        getWeiboInfo(url);
    }
}
