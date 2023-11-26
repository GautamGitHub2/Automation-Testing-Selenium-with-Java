package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropDown_GoogleSearch {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.safaridriver().setup();
            WebDriver driver= new SafariDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

            driver.findElement(By.name("q")).sendKeys("java tutorial");
            Thread.sleep(3000);

            List<WebElement> list=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]/span"));

            System.out.println("Size of Auto Suggestions:"+list.size());//Size of Auto Suggestions:12


            for (WebElement listitem:list)
            {
                if(listitem.getText().contains("beginners"))
                {
                    listitem.click();
                    System.out.println("Clicked 1st option java tutorial Successfull...!! ");//Clicked 1st option java tutorial Successfull...!!
                    System.out.println("This program is working 100% perfectly...!! ");//This program is working 100% perfectly...!!
                    break;

                }
            }


        }
    }


