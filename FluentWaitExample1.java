package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitExample1 {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        //Fluent wait declaration
        Wait<WebDriver> mywait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        //Usage of Fluent wait
        WebElement element=mywait.until((new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//h3[text()='Selenium WeDriver']"));
            }
        }));
        element.click();

    }

}
