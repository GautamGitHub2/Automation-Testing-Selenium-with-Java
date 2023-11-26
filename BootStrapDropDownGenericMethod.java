package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class BootStrapDropDownGenericMethod {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        // here i am expalianing about the HDFC bank, this webpage has been updated to latest version so the below web elements are currently not available so by running below code error / exceptions might come but the concepts are quite correct follow the below youtube url
        // https://www.youtube.com/watch?v=gplxQ3mtmGY&list=PLUDwpEzHYYLtEENXAFbVPrLeLNHM6OLk7&index=11

        driver.get("https://www.hdfcbank.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();

        //Product Types
        List<WebElement> productTypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

        System.out.println("Number of options:"+productTypes);//14
        selectOptionFromDropDown1(productTypes,"Accounts");

        //Product
        driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
        List<WebElement> products=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));

        System.out.println("Number of options:"+products);
        selectOptionFromDropDown1(products,"Savings Acounts");
    }

    //BootStrapDropDownGenericMethod the Very Important Concept
    public static void selectOptionFromDropDown1(List<WebElement> options, String value) {
        for (WebElement option:options)
        {
            if(option.getText().equals(value))
            {
                option.click();
                break;
            }
        }
    }
}
