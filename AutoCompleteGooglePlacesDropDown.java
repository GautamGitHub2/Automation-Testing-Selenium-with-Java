package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class AutoCompleteGooglePlacesDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.twoplugs.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

        WebElement searchBox=driver.findElement(By.id("autocomplete"));
        searchBox.clear();

        searchBox.sendKeys("Toronto");
        Thread.sleep(3000);

        String text;

        do {
            searchBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(3000);

            text=searchBox.getAttribute("value");

            if(text.equals("Toronto, OH, USA"))
            {
                searchBox.sendKeys(Keys.ENTER);
                System.out.println("This Program is working as expected, Successfully clicked on Toronto, OH, USA ");//This Program is working as expected, Successfully clicked on Toronto, OH, USA
                break;
            }
            Thread.sleep(3000);

        }while(!text.isEmpty());
    }
}
