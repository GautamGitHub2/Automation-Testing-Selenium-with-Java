package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitExample2 {

    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //Explicit wait
        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        By elelocator=By.xpath("//h3[text()='Selenium WebDriver']");
        waitForElementPresent(driver, elelocator,10).click();

    }

    //Generic Method for the Explicit Wait
    public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        return driver.findElement(locator);
    }

}

