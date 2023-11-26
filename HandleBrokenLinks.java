package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleBrokenLinks {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links=driver.findElements(By.tagName("a"));

        int brokenLinks=0;

        for (WebElement element:links)
        {
            String url=element.getAttribute("href");
            if (url==null || url.isEmpty())
            {
                System.out.println("URL is empty");
                continue;
            }

            URL link=new URL(url);

            try
            {
                HttpURLConnection httpConn=(HttpURLConnection) link.openConnection();
                httpConn.connect();

                if (httpConn.getResponseCode()>=400)
                {
                    System.out.println(httpConn.getResponseCode()+url+"  is"+"  Broken link");
                    brokenLinks++;
                }
                else
                {
                    System.out.println(httpConn.getResponseCode()+url+" is"+"  Valid Link");
                }
            }
            catch (Exception e)
            {

            }
        }
        System.out.println("Number of broken links:"+brokenLinks);
        driver.quit();

        // This code is working 100% correct
    }
}
