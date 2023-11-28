package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HandleFrame {

    //This code is old and conceptually working as expected as per the website designed 2 years ago...

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        //1st Frame
        driver.switchTo().frame("packageListFrame");//name of the frame
        driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();

        //If 1st frame is clicked then driver will continue to the 1st frame only and till will till there untill i come out from this 1st frame. fro switching back to the main page
        // user should use another method like mentioned below
        driver.switchTo().defaultContent();// go back to the main page
        Thread.sleep(3000);

        //2nd Frame
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();//this is customize /relative xPath this can be vary time to time or can be written in other way.
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        //3rd Frame
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();//Help

    }
}
