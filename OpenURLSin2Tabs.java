package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.safari.SafariDriver;

public class OpenURLSin2Tabs {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://demo.nopcommerce.com/");
        //driver.switchTo().newWindow(WindowType.TAB);// it will open 2nd URL in another tab
        driver.switchTo().newWindow(WindowType.WINDOW);// it will open 2nd URL in another window
        driver.get("https://www.opencart.com/"); // This will open in same tab as previous one

        // So in this cae i want to open 2nd URL in separate tab

    }
}
