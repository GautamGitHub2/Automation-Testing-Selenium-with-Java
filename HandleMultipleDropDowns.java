package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleMultipleDropDowns {

    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

        /*
        //Approach-1
        Select noOfEmpdrp=new Select(driver.findElement(By.name("NoOfEmployees")));
        noOfEmpdrp.selectByVisibleText("16 - 20");

        Select industryDrp=new Select(driver.findElement(By.name("Industry")));
        industryDrp.selectByVisibleText("Travel");

        Select countryDrp=new Select(driver.findElement(By.xpath("Country")));
        countryDrp.selectByVisibleText("Aruba");
        */

        //Approach-2
        WebElement noOfEmpsEle=driver.findElement(By.name("NoOfEmployees"));
        selectOptionFromDropDown(noOfEmpsEle,"16 - 20");

        WebElement industryEle=driver.findElement(By.name("Industry"));
        selectOptionFromDropDown(industryEle,"Travel");

        WebElement country=driver.findElement(By.name("Country"));
        selectOptionFromDropDown(country,"Aruba");

        }
        public static void selectOptionFromDropDown(WebElement ele, String value)
        {
            Select drp=new Select(ele);
            List<WebElement> allOptions=drp.getOptions();// working as expected

            for (WebElement option:allOptions)
            {
                if (option.getText().equals(value))
                {
                    option.click();
                    break;
                }
            }

        }
}
