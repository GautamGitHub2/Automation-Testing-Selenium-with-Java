package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePicker_DropDown {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='dob']")).click();

        //Month & Year Selection
        Select month_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        month_drp.selectByVisibleText("Nov");

        Select year_drp=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        year_drp.selectByVisibleText("1992");

        String date="2";

        //Date Selection
        List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td")); //here all the dates have been captured by the xPath, now i have to make a looping statement and compare with the if condition to the date that i want to select
        for (WebElement ele:allDates)
        {
            String dt=ele.getText();

            if (dt.equals(date))
            {
                ele.click();
                //System.out.println("This is my Birth Date..!!");
                break;
            }
        }
    }
}
