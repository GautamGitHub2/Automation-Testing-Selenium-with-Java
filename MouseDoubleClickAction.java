package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class MouseDoubleClickAction {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");

        WebElement field1= driver.findElement(By.xpath("//input[@id='field1']"));
        field1.clear();
        field1.sendKeys("Hello Gautam Kumar!");

       // WebElement buttonCopyText=driver.findElement(By.xpath("//button[text()='Copy Text']"));

        WebElement buttonCopyText=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        Actions act=new Actions(driver);
        act.doubleClick(buttonCopyText).perform();//Perform Double Click Operation

    }
}
