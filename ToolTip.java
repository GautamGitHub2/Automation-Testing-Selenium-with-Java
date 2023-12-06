package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class ToolTip {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://jqueryui.com/tooltip/");

        driver.switchTo().frame(0);
        WebElement inputBox=driver.findElement(By.xpath("//input[@id='age']"));
        String toolTipText=inputBox.getAttribute("title");
        System.out.println(toolTipText);//We ask for your age only for statistical purposes.

        // Continue with more ToolTip
    }
}
