package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDown_BingSearch {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver= new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");

        List<WebElement> list=driver.findElements(By.xpath("//li[@class='sa_sg as_extra_pad']//span"));

        System.out.println("Size of Auto Suggestions:"+list.size());//Size of Auto Suggestions:7

        for (WebElement listitem:list)
        {
            if(listitem.getText().contains("download"))
            {
                listitem.click();
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();

    }
}
