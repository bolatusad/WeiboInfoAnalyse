package com.xupt.zxh.graduation.project.spider;

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
@WebAppConfiguration(value = "src/main/webapp")
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
        String cookie = "SCF=Av5HaQUPgp7hckAmpKmJVLiR5VS0dZZaDnmhZO_zlEvO3SS4V2gpMFgpVNspYuDQZuZxfj9TDrBHSXVWLVtadZY.; SUHB=0D-1Tn6FOB0aBJ; _T_WM=1623cca022b68c93acdbb935aea64b11; SSOLoginState=1495779566; ALF=1498371565; SUB=_2A250I7i-DeRhGeBO7FcW8i_EyjiIHXVX79j2rDV6PUJbktAKLUTzkW2AtitpxXynRDuwRESiaBKe3NjnVw..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75JpX5o2p5NHD95QcehMfS0zp1h2XWs4DqcjlggvfBPiLKPLedN9Lggvf";
//        String cookie = "SCF=Ag9in2c5luQWfoiK4-NZyuaz0-4g-n6SzFHy6DdgMvN9re640N7DGALBQHBlsBogfhsbR5N-AWNsOeBhgLm68vk.;" +
//                "ALC=ac%3D27%26bt%3D1495691960%26cv%3D5.0%26et%3D1527227960%26ic%3D1905022530%26scf%3D%26uid%3D6075721814%26vf%3D1%26vs%3D0%26vt%3D2%26es%3Dd6948acacc62027106d60285be90f702;" +
//                "ALF=1527227960;sso_info=v02m6alo5qztKWRk5yljpOQpZCToKWRk5iljoOgpZCjnLaMg5y1jbOIsY6DhLSJp5WpmYO0toyDnLWNs4ixjoOEtA==;" +
//                "cREMloginname=13382247424;SSOLoginState=1495691961;" +
//                "U_TRS1=00000042.b2812c63.592672ba.b9e983bd;U_TRS2=00000042.b2902c63.592672ba.277b2b78;" +
//                "WEB2=8acef34509963ba1d26b27abb9aa496d;SWB=usrmdinst_9;" +
//                "bdshare_firstime=1495691966589;INTDPOOL=36c462ea77b0cc909c32500618674e49;tuijian=usrmdinst_2;" +
//                "WEB3=b9b8665222e30e1531ca66024d3b28f5;PHPSESSID=88tm020ihrq43pch9g2ajea2q4;UOR=login.sina.com.cn,my.sina.com.cn,;" +
//                "WEB3=16eecaac1b039ffa98ceae90acb175f9;tgc=TGT-NjA3NTcyMTgxNA==-1495691969-gz-A29236C112CB6E65396698E733AF4706-1;" +
//                "SUB=_2A250IgKRDeRhGeBO7FcW8i_EyjiIHXVX7K7ZrDV_PUJbm9BeLXXBkW1HSK0AUBzSPkSZCwAT1UDmyjLT5A..;" +
//                "SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75NHD95QcehMfS0zp1h2XWs4DqcjlggvfBPiLKPLedN9Lggvf;" +
//                "LT=1495691969;SCF=Ag9in2c5luQWfoiK4-NZyuaz0-4g-n6SzFHy6DdgMvN9icJnI8cFGYEEjgDXYVbzncU-QB35F7s4IUIr6wIFMOw.;" +
//                "SUB=_2A250IgKRDeRhGeBO7FcW8i_EyjiIHXVXVnNZrDV8PUJbmtBeLRPCkW8Qh3X6mFpxRhCd9MvPnByJGDLgnw..;" +
//                "SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75JpX5o2p5NHD95QcehMfS0zp1h2XWs4DqcjlggvfBPiLKPLedN9Lggvf;" +
//                "SUHB=0idbr50Px2i0BU;SRT=D.QqHBJZ4nNdWI4!Mb4cYGS4HLirSZPqY9QrPuTcbHNEYddESlOb9pMERt4EP1RcsrAcPJ4bBDTsVt4dXqdDSkMeBt4cYDSDbiWbBlAeb1MrMJS-u3I8t7*B.vAflW-P9Rc0lR-ykVDvnJqiQVbiRVPBtS!r3JZPQVqbgVdWiMZ4siOzu4DbmKPWQS4utN-iOU4sdWQPmJZHlJFSPO4R3i49ndDP6JevsO!YmKOPMR-PfOdSOJG9nJdXpdEWqimMoR-9jS-W-S!HAT4oI4mobSmtuOFWeWcR7;" +
//                "SRF=1495691969;ALF=1527227960;SSOLoginState=1495691969;" +
//                "ALF=1498283969;ALF=1498283970;" +

//                "SCF=Ag9in2c5luQWfoiK4-NZyuaz0-4g-n6SzFHy6DdgMvN9C5zEvhLHPA310hcS2-RgAkOsT5cYQ0anqhqnUphdw-0.;" +
//                "SUB=_2A250IgKSDeRhGeBO7FcW8i_EyjiIHXVX7K7arDV6PUJbktBeLWamkW18T5g10TnvhaNSkQxCUl9-tfDXcQ..;" +
//                "SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75JpX5o2p5NHD95QcehMfS0zp1h2XWs4DqcjlggvfBPiLKPLedN9Lggvf;" +
//                "SUHB=0y0pTBRQ07K4dG;SSOLoginState=1495691970;_T_WM=7244c3d13553cd601acc6212be7c3154;";
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
        System.out.println("===============================================>");
        System.out.println(Jsoup.parse(EntityUtils.toString(httpEntity)));
        System.out.println("<================================================");
//        Document document = Jsoup.parse(EntityUtils.toString(httpEntity));
//        myPage.setDocument(document);
//        parseWeiboInfo(myPage);
//        //暂停5秒
//        Thread.sleep(5000);
//        //判断是否有下一页的链接，若有添加到next中，若没有则什么也不做
//        Element preNextPage = document.getElementById("pagelist");
//        Elements next = preNextPage.getElementsByTag("a");
////        Elements nextPage = preNextPage.getElementsByAttributeValueContaining("href", "?page=");
//        if(next.size()>0 && "下页".equals(next.get(0).text().trim())){
//            String nextPageUrl = "http://weibo.cn"+next.get(0).attr("href");
//            System.out.println(nextPageUrl);
//            getWeiboInfo(nextPageUrl);
//        }
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
        String url = "https://weibo.cn/u/1984666617";
//        String url = "https://weibo.cn";
//        String url = "http://weibo.cn/u/2143272275";
        getWeiboInfo(url);
    }
}
