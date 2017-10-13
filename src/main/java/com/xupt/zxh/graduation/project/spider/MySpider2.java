package com.xupt.zxh.graduation.project.spider;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.service.weibo.ISensitiveService;
import com.xupt.zxh.graduation.project.service.weibo.IWeiboInfoService;
import com.xupt.zxh.graduation.project.spider.Util.MyPage;
import com.xupt.zxh.graduation.project.spider.parse.ParseWeiboInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 张涛 on 2017/5/26.
 */
public class MySpider2 {


    @Autowired
    private ISensitiveService sensitiveService;

    private static WebClient client;

    public void getWeiboInfo(String url,Integer userId,IWeiboInfoService weiboInfoService) throws IOException, InterruptedException {
        if(client == null){
            client = GetCookie2.getClient();
        }
        HtmlPage page = client.getPage(url);
        MyPage myPage = new MyPage();
        myPage.setUrl(url);
        Document document = Jsoup.parse(page.asXml());
        System.out.println("===================================>");
        System.out.println(document);
        System.out.println("<===================================");
        myPage.setDocument(document);
        parseWeiboInfo(myPage,userId,weiboInfoService);
        //暂停5秒
        Thread.sleep(5000);
        //判断是否有下一页的链接，若有添加到next中，若没有则什么也不做
        Element preNextPage = document.getElementById("pagelist");
        Elements next = preNextPage.getElementsByTag("a");
//        Elements nextPage = preNextPage.getElementsByAttributeValueContaining("href", "?page=");
        if(next.size()>0 && "下页".equals(next.get(0).text().trim())){
            String nextPageUrl = "http://weibo.cn"+next.get(0).attr("href");
            System.out.println(nextPageUrl);
            getWeiboInfo(nextPageUrl,userId,weiboInfoService);
        }
    }

    /**
     * 设置cookie
     * @param client
     * @param cookieSet
     * @return
     */
    public WebClient setCookie(WebClient client, Set<Cookie> cookieSet){
        String cookiesStr ="SCF=Aj30u1imKcjGAh3zYEdnSIxXYH7H0EnbVWyvfEK77HEibxeb7yeY13ndoBl4sPuVDEehPqEyc5KXmEfps5r-9Ec.;ALC=ac%3D27%26bt%3D1495784377%26cv%3D5.0%26et%3D1527320377%26ic%3D1905022530%26scf%3D%26uid%3D6075721814%26vf%3D1%26vs%3D0%26vt%3D2%26es%3Db62233f33b1c90a504badb36f41621a3;ALF=1527320377;sso_info=v02m6alo5qztKWRk5yljpOQpZCToKWRk5iljoOgpZCjnLaMg5y1jbOIsY6DhLSJp5WpmYO0toyDnLWNs4ixjoOEtA==;cREMloginname=13382247424;SSOLoginState=1495784378;U_TRS1=00000051.15475efa.5927dbbb.f53d6066;U_TRS2=00000051.15505efa.5927dbbb.3e45ec62;WEB2=18d094bed080194d15a9994bba0de5fb;SWB=usrmdinst_13;bdshare_firstime=1495784384218;INTDPOOL=dc04044687467eb79001316b5643db06;tuijian=usrmdinst_1;WEB3=5a5a4ffe6c5480c798c8f7f6719232cd;PHPSESSID=11jf5o0rrnjfjdcmfoecg3jrj7;UOR=login.sina.com.cn,my.sina.com.cn,;WEB3=97998c01b1b3f3d2bfc2368639388511;ULV=1495784389764:1:1:1::;tgc=TGT-NjA3NTcyMTgxNA==-1495784386-tc-F324ED1FED15C2AABC7196A4F6C867CF-1;SUB=_2A250I6uSDeRhGeBO7FcW8i_EyjiIHXVX7zXarDV_PUJbm9AKLW3CkW0bvwyIwuKlrYe-oPMT8K7_TSirqA..;SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75NHD95QcehMfS0zp1h2XWs4DqcjMi--NiK.Xi-2Ri--ciKnRi-zNSo5NSKMEeKnpS5tt;LT=1495784387;SCF=Aj30u1imKcjGAh3zYEdnSIxXYH7H0EnbVWyvfEK77HEiKoG4lKHLQSoB0mOTsmP4GtgCVGGvu-HsiZoqnwb4cCg.;SUB=_2A250I6uTDeRhGeBO7FcW8i_EyjiIHXVXWJpbrDV8PUJbmtBeLU3ukW8cR4lHd1EZ-d4aLOWQnKQVb0pGpg..;SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75JpX5o2p5NHD95QcehMfS0zp1h2XWs4DqcjlggvfBPiLKPLedN9Lggvf;SUHB=0sqxqDAjuPpkg4;SRT=D.QqHBJZ4nNOSsPmMb4cYGS4HLirSZPqY9QrPuTcbHNEYddEW1VFHpMERt4EP1RcsrAcPJPOisTsVtRszrUmY!J4PTIdArR4oLPsElNsEdRZBnM3BeI8t7*B.vAflW-P9Rc0lR-ykVDvnJqiQVbiRVPBtS!r3JZPQVqbgVdWiMZ4siOzu4DbmKPWQS4utN-iOU4sdWQPmJZHlJFSPO4R3i49ndDP6JevsO!YmKOPMR-PfOdSOJG9nJdXpdEWqimMoR-9jS-W-S!HAT4oI4mobSmtuOFWeWcR7;SRF=1495784387;ALF=1527320377;SSOLoginState=1495784388;ALF=1498376388;ALF=1498376388;SCF=Aj30u1imKcjGAh3zYEdnSIxXYH7H0EnbVWyvfEK77HEiBAaGNaZSU4rHkj3QyNKb6zHfEnytchS5lRXNajqmUfM.;SUB=_2A250I6uUDeRhGeBO7FcW8i_EyjiIHXVX7zXcrDV6PUJbktBeLWf6kW2Mc-ftkLiBf1ZF9a4mbwvXERpoSg..;SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWeNxKcSmMVuuD22n0fUMF75JpX5o2p5NHD95QcehMfS0zp1h2XWs4DqcjlggvfBPiLKPLedN9Lggvf;SUHB=0idbr50Px2i0BU;SSOLoginState=1495784388;_T_WM=1b98dae7ab535c728cbb592ac0568713;";
        String[] cookieStr = cookiesStr.split(";");
        Set<Cookie> cookieSet1 = new TreeSet<Cookie>();
        for(String str:cookieStr){
            String[] cookieArray = str.split("=");
            if(cookieArray.length == 2){
                Cookie cookie = new Cookie(".weibo.com",cookieArray[0],cookieArray[1]);
                client.getCookieManager().addCookie(cookie);
//                cookieSet1.add(cookie);
            }
        }

//        for(Cookie cookie : cookieSet1){
//            client.getCookieManager().addCookie(cookie);
//        }
        return client;
    }


    /**
     * 用于解析页面中的微博信息
     * @param myPage
     * @return
     */
    public List<WeiboInfo> parseWeiboInfo(MyPage myPage,Integer userId,IWeiboInfoService weiboInfoService) throws UnsupportedEncodingException {
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
                weiboInfo.setUserId(userId);
                System.out.println(weiboInfo);
                //插入数据并返回主键
                weiboInfoService.insertWeiboInfo(weiboInfo);
                //进行敏感词分析
                sensitiveService.sensitiveAnalyse(weiboInfo);

            }
        }
        return weiboInfos;
    }

//    @Test
//    public void myWeiboInfo() throws IOException, InterruptedException {
//        String url = "https://weibo.cn/u/1984666617";
////        String url = "https://weibo.cn";
////        String url = "http://weibo.cn/u/2143272275";
//        getWeiboInfo(url);
//    }

}
