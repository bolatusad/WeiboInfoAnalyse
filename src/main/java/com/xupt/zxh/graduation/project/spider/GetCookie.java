package com.xupt.zxh.graduation.project.spider;

import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * 获取微博的cookie
 * 
 * @author 张涛
 * 
 */
public class GetCookie {

    // 原来的爬虫： http://login.weibo.cn/login/
	public static final String url = "https://passport.weibo.cn/signin/login";

//	public static final String username = "13202683631";
	public static final String username = "13382247424";

	public static final String password = "a123456";
//	public static final String password = "jijie0716";

	public GetCookie(){
		
	}
	
	/**
	 * 根据用户名和密码获取cookie，针对的网站时微博手机版，weibo.cn
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public static String getCookie(String username, String password) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.setJavascriptEnabled(true);
		driver.get(url);
		WebElement element = driver.findElementByTagName("img");
		String src = element.getAttribute("src");
		String cookies = concatCookie(driver);
		HttpRequest httpRequest = new HttpRequest(src);
		httpRequest.setCookie(cookies);
		HttpResponse response = httpRequest.getResponse();
        ByteArrayInputStream is = new ByteArrayInputStream(response.getContent());
        BufferedImage img = ImageIO.read(is);
        is.close();
        ImageIO.write(img, "png", new File("result.png"));
        String userInput = new CaptchaFrame(img).getUserInput();
        WebElement mobile = driver.findElementByCssSelector("input[name=mobile]");
        mobile.sendKeys(username);
        //^= CSS选择器里面的内容，指的是以 指定内容 开头的元素
        WebElement pass = driver.findElementByCssSelector("input[name^=password]");
        pass.sendKeys(password);
        WebElement code = driver.findElementByCssSelector("input[name=code]");
        code.sendKeys(userInput);
        WebElement rem = driver.findElementByCssSelector("input[name=remember]");
        rem.click();
        WebElement submit = driver.findElementByCssSelector("input[name=submit]");
        submit.click();
        String result = concatCookie(driver);
        System.out.println(result);
        driver.close();
        if (result.contains("gsid_CTandWM")) {
            return result;
        } else {
            throw new Exception("weibo login failed");
        }
	}

	/**
	 * 用于拼接cookies
	 * @param driver
	 * @return
	 */
	public static String concatCookie(HtmlUnitDriver driver) {
		Set<Cookie> cookieSet = driver.manage().getCookies();
		StringBuilder sb = new StringBuilder();
		for (Cookie cookie : cookieSet) {
			sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
		}
		String result = sb.toString();
		return result;
	}

    public static String concatCookie2(Set<com.gargoylesoftware.htmlunit.util.Cookie> cookieSet) {
        StringBuilder sb = new StringBuilder();
        for (com.gargoylesoftware.htmlunit.util.Cookie cookie : cookieSet) {
            sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
        }
        String result = sb.toString();
        return result;
    }


    /**
     * 再次获取cookie
     */
	public static void getCookieAgain() throws IOException {

//        StringBuilder stringBuilder = new StringBuilder();
//        HtmlUnitDriver driver = new HtmlUnitDriver();
//        driver.setJavascriptEnabled(true);
//        driver.get("http://login.sina.com.cn/sso/login.php?client=ssologin.js(v1.3.16)");
//        String cookies = concatCookie(driver);
//
//        System.out.println(driver.findElementByTagName("title").getText());
//        WebElement mobile = driver.findElementById("username");
//        WebElement pass = driver.findElementById("password");
//        WebElement remeber = driver.findElementById("remLoginName");
//        mobile.sendKeys(username);
//        pass.sendKeys(password);
//        remeber.click();
//        WebElement login = driver.findElementByXPath("//input[@type='submit'][1]");
//        login.click();
//        String result = concatCookie(driver);
//        System.out.println("=============================================>");
//        Set<Cookie> cookie = driver.manage().getCookies();
//        System.out.println();
//        System.out.println(result);

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
        System.out.println("==========================>");
        System.out.println(page3.asXml());
        System.out.println("<==========================");
//        登录完成，现在可以爬取任意你想要的页面了。
        Set<com.gargoylesoftware.htmlunit.util.Cookie> cookie = client.getCookieManager().getCookies();
        String cookiesss = concatCookie2(cookie);
        System.out.println(cookiesss);

    }

	@Test
	public void test() throws Exception {
//		getCookie(username, password);

        getCookieAgain();
	}
	
	/**
	 * 用于显示图片验证码，让用户去输入
	 * @author 张涛
	 *
	 */
	public static class CaptchaFrame {

        JFrame frame;
        JPanel panel;
        JTextField input;
        int inputWidth = 100;
        BufferedImage img;
        String userInput = null;

        public CaptchaFrame(BufferedImage img) {
            this.img = img;
        }

        public String getUserInput() {
            frame = new JFrame("输入验证码");
            final int imgWidth = img.getWidth();
            final int imgHeight = img.getHeight();
            int width = imgWidth * 2 + inputWidth * 2;
            int height = imgHeight * 2+50;
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int startx = (dim.width - width) / 2;
            int starty = (dim.height - height) / 2;
            frame.setBounds(startx, starty, width, height);
            Container container = frame.getContentPane();
            container.setLayout(new BorderLayout());
            panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(img, 0, 0, imgWidth * 2, imgHeight * 2, null);
                }
            };
            panel.setLayout(null);
            container.add(panel);
            input = new JTextField(6);
            input.setBounds(imgWidth * 2, 0, inputWidth, imgHeight * 2);
            panel.add(input);
            JButton btn = new JButton("登录");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userInput = input.getText().trim();
                    synchronized (CaptchaFrame.this) {
                        CaptchaFrame.this.notify();
                    }
                }
            });
            btn.setBounds(imgWidth * 2 + inputWidth, 0, inputWidth, imgHeight * 2);
            panel.add(btn);
            frame.setVisible(true);
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            frame.dispose();
            return userInput;
        }
    }


}
