package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class MouseRightClickAction {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions act=new Actions(driver);

        act.contextClick(button).perform(); //will perform right click operation, perform is nothing but the build().perform(), both are same.

        System.out.println("Right Click Operation performed successfully...");
        //act.contextClick(button).build().perform();// this is also true for right click operation, here 1st it will create build for this operation then it will right click.
    }
}
