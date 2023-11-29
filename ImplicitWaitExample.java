package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ImplicitWaitExample {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//h3[text()='Selenium WebDriver']")).click();

        // This code is 100% correct, it cam be vary due to the xPath depends on the availablity of the web element at the web page.

    }
}
