package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDown {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        //driver.get("https://www.opencart.com/index.php?route=account/register");

        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        //https://www.globalsqa.com/demo-site/select-dropdown-menu/

        WebElement dropDownCountryEle=driver.findElement(By.xpath("//*[@id='post-2646']/div[2]/div/div/div/p/select"));

        Select dropDownCountry=new Select(dropDownCountryEle);

        //dropDownCountry.selectByVisibleText("Albania");// Albania entered to the drop down, this is working as expected
        //dropDownCountry.selectByValue("ARG");//Argentina entered successfully
        //dropDownCountry.selectByIndex(5);//this is not given at the web page as web element, this is just assumption and starting from 0

        //Q. How to select the values from drop down without using the select method means without using  Select dropDownCountry=new Select(dropDownCountryEle);

        //selecting option from dropdown without using methods
        List<WebElement> allOptions=dropDownCountry.getOptions();// working as expected

        for (WebElement option:allOptions)
        {
            if (option.getText().equals("Albania"))
            {
                option.click();
                break;
            }
        }
        //but this method will be complex if the web-page contains multiple drop downs in the website, so to overcome this we should develop another method



    }


}
