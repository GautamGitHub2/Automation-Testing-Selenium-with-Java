package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class StatusOfWebElement {

    public static void main(String [] args)
    {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        driver.get("https://demo.nopcommerce.com/register");

        //isDisplayed() isEnabled()
        WebElement searchStore=driver.findElement(By.xpath("//input[@id='small-searchterms']"));

        System.out.println("Display status:"+searchStore.isDisplayed());//true
        System.out.println("Enabled status:"+searchStore.isEnabled());//true

       //isSelected() --> radio buttons, check boxes, drop down
        WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));

        System.out.println(male.isSelected());//false
        System.out.println(female.isSelected()); //false

        male.click(); // selects male radio button
        System.out.println(male.isSelected());//true
        System.out.println(female.isSelected());//false

        female.click(); // selects female radio button
        System.out.println(male.isSelected());//false
        System.out.println(female.isSelected());//true

    }

}
