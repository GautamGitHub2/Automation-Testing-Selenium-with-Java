package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Navigations {

    public static void main(String [] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        //RemoteWebDriver driver = new SafariDriver();

        driver.get("https://www.snapdeal.com");
        //driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.amazon.com");//this will do the same as driver.get()

        driver.navigate().back();//snapdeal
        driver.navigate().forward();//amazon

        driver.navigate().refresh();//refresh or reload the page
    }
    }
