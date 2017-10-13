package com.xupt.zxh.graduation.project.spider;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.io.IOException;
import java.util.Set;

/**
 * Created by 张涛 on 2017/5/26.
 */
public class GetCookie2 {

//    public static final String username = "13202683631";
    public static final String username = "13382247424";

    public static final String password = "a123456";
//	public static final String password = "jijie0716";

    public static WebClient getClient() throws IOException {
        WebClient client = new WebClient(BrowserVersion.FIREFOX_24);
        client.getOptions().setJavaScriptEnabled(true);    //默认执行js，如果不执行js，则可能会登录失败，因为用户名密码框需要js来绘制。
        client.getOptions().setCssEnabled(false);
        client.setAjaxController(new NicelyResynchronizingAjaxController());
        client.getOptions().setThrowExceptionOnScriptError(false);

        HtmlPage page = client.getPage("http://login.sina.com.cn/sso/login.php?client=ssologin.js(v1.3.16)");
        //System.out.println(page.asText());

        //登录

        HtmlInput ln = page.getHtmlElementById("username");
        HtmlInput pwd = page.getHtmlElementById("password");
        HtmlInput btn = page.getFirstByXPath("//input[@type='submit'][1]");


        ln.setAttribute("value",username);
        pwd.setAttribute("value", password);

        HtmlPage page2 = btn.click();
        HtmlPage page3 =  client.getPage("https://weibo.cn/");
//        登录完成，现在可以爬取任意你想要的页面了。
        Set<Cookie> cookie = client.getCookieManager().getCookies();
        String cookiesss = concatCookie2(cookie);
        System.out.println(cookiesss);
        return client;
    }

    public static String concatCookie2(Set<com.gargoylesoftware.htmlunit.util.Cookie> cookieSet) {
        StringBuilder sb = new StringBuilder();
        for (com.gargoylesoftware.htmlunit.util.Cookie cookie : cookieSet) {
            sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
        }
        String result = sb.toString();
        return result;
    }

}
