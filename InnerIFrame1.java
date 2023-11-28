package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class InnerIFrame1 {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

       WebElement outerIframe= driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
       driver.switchTo().frame(outerIframe);//Here i am passing frame as a webelement

       WebElement innerIframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
       driver.switchTo().frame(innerIframe);

       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Gautam");
       //working as expected 100% correctly.

    }
}
