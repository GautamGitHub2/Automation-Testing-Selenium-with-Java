package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class InnerFrame2 {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");//Switch to outer iframe
        driver.switchTo().frame(0);//switch to inner iframe

        System.out.println("Text present inside the inner frame:"+driver.findElement(By.xpath("//h1")).getText());//Text present inside the inner frame:This page is displayed in an iframe
        //Till here working as expected

        driver.switchTo().parentFrame();//go to parent frame / outer frame
        String text=driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to specify the size of the iframe:']")).getText();
        //p[contains(text(),'You can use the height and width attributes to specify the size of the iframe:']
        System.out.println("Text present inside the outher frame:"+text);






    }
}
