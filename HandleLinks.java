package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class HandleLinks {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        //driver.findElement(By.linkText("Today's Deals")).click();//Working as expected
        //driver.findElement((By.partialLinkText("Deals"))).click();//Working as expected

        // How to capture all the links
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Number of links present:"+links.size());//Number of links present:372

        // Normal For loop
        /*for(int i=0;i<=links.size();i++)
        {
            System.out.println(links.get(i).getText());
            System.out.println(links.get(i).getAttribute("href"));
        }*/

        //For Each Loop
        for (WebElement link:links)
        {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }

        //How to handle broken links; broken links are nothing but the link that do not have target page, after clicking on that link it will not navigate to any target page, there no any target page on the server
    }
}
