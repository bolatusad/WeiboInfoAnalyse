package com.xupt.zxh.graduation.project.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;

/**
 * Created by 张涛 on 2017/5/6.
 */
public class MyHttpUtil {

    /**
     * get请求，并返回结果
     * @param url
     * @return
     * @throws IOException
     */
    public static String requestGet(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String cookie = "SCF=Av5HaQUPgp7hckAmpKmJVLiR5VS0dZZaDnmhZO_" +
                "zlEvO-yeYu0albd0UK6202zpwv3V-N2ps-Y5FVvCB70Nf28A.; " +
                "SUHB=0wnl7rEBI2JMum; " +
                "UOR=www.eebbk.com,widget.weibo.com,login.sina.com.cn; " +
                "SINAGLOBAL=8837046564062.465.1475027234154; " +
                "ULV=1494068265624:62:4:4:4602676731127.185.1494068265615:1494037401816; " +
                "SUBP=0033WrSXqPxfM72wWs9jqgMF55529P9D9WhfuI.KmWnXyhsn93ECuqT85JpV2K2NSo57S0n4e095MP2Vqcv_; " +
                "UM_distinctid=15b93a993b2de-093107963af8b48-1262694a-100200-15b93a993b3ac; " +
                "YF-Ugrow-G0=ad83bc19c1269e709f753b172bddb094; " +
                "SUB=_2AkMuUTe4dcNxrABYmP8XyGzqZIpH-jydhF5OAn7uJhMyAxgv7lAgqSVER9_AQxr9lpJCrJYUqmJ4NlHKZw..; " +
                "YF-V5-G0=7fb6f47dfff7c4352ece66bba44a6e5a; " +
                "YF-Page-G0=7b9ec0e98d1ec5668c6906382e96b5db; " +
                "_s_tentry=login.sina.com.cn; " +
                "Apache=4602676731127.185.1494068265615; " +
                "login_sid_t=f0228a3dab70a5c45b011ea4f1f7b32c; WBStorage=02e13baf68409715|undefined";
        httpGet.setHeader("Host","weibo.com");
        httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpGet.setHeader("Accept-Encoding","gzip, deflate");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
        httpGet.setHeader("Cookie", cookie);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity);
    }

    /**
     * 利用HTMLUnit去执行get请求，用于获取执行Javascript之后的HTML
     */
    public static void requestGetByHtmlUnit(String url){
        HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver();
        htmlUnitDriver.setJavascriptEnabled(true);
        Cookie cookie = new Cookie("SUB","_2AkMuUTe4dcNxrABYmP8XyGzqZIpH-jydhF5OAn7uJhMyAxgv7lAgqSVER9_AQxr9lpJCrJYUqmJ4NlHKZw..");
        htmlUnitDriver.manage().addCookie(cookie);
        htmlUnitDriver.get(url);
    }
}
