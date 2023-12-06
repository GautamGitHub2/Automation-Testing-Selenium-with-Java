package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class OpenLinkInTheNewTab {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://demo.nopcommerce.com/");
        String tab= Keys.chord(Keys.COMMAND,Keys.RETURN);

        //driver.findElement(By.linkText("Register")).sendKeys(tab);
        driver.findElement(By.xpath("//a[@class='ico-register']")).sendKeys(tab);
        System.out.println("The Register link has been opened in new tab successfully...");
    }
}
