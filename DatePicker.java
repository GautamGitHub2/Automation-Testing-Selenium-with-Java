package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        String year="2023";
        String month="December";
        String date="5";

        driver.findElement(By.xpath("//div//span[@class='dateText']")).click();//open the date picker

        // Logic According to Old version of the webpage, this is correct logic 100% in working conditions
        while (true)
        {
            String monthYear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();

            String arr[]=monthYear.split(" ");
            String mon=arr[0];
            String yr=arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equals(year))
                break;
            else
                driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
        }

        //date selection
        List<WebElement> alldates=driver.findElements(By.xpath("//div[@class='sc-kAzzGY llxTcS']"));

        for (WebElement ele:alldates)
        {
            String dt=ele.getText();
            if (dt.equals(date))
            {
                ele.click();
                break;
            }
        }



    }
}
