package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

    public class OpenSafariBrowser {

        public static void main(String[] args) {

            // Instantiate a SafariDriver class.
            //WebDriver driver = new SafariDriver();

            // Launch Website
            // driver.navigate().to("http://www.google.com/");
            //driver.navigate().to("http://www.youtube.com/@igautam.nov2");

            // Click on the search text box and send value
            //driver.findElement(By.id("lst-ib")).sendKeys("javatpoint tutorials");

            // Click on the search button
            //driver.findElement(By.name("btnK")).click();

            //**** Using WebDriverManager *****

            WebDriverManager.safaridriver().setup();
            WebDriver driver = new SafariDriver();

            driver.navigate().to("https://www.google.com/");
            System.out.println("Title of Page:"+  driver.getTitle());
            System.out.println("Current URL of the Page:"+ driver.getCurrentUrl());
            //System.out.println("Page Source of the Webpage:"+driver.getPageSource());

            //https://demo.nopcommerce.com/register --> I will be using this website for the automation testing practice

            //driver.wait(1000);

            // Close the Browser
            driver.quit();

        }
    }

