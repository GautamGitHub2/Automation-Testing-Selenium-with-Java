package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.FindBy;

public class PermissionPopupNotification {
    public static void main(String[] args) {

        //SafariOptions options=new SafariOptions();
        //options.addArguments("--disable-notifications");//This is code to disable permission pop-up here in safari i am not getting permission pop-up but the code is fine
        //For Chrome Driver use ChromeOptions but addArguments is depricated didn't see this method inside the SafariOptions() and didn't get any info in google about this.

        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();//for SafariOptions or ChromeOptions use "options" ref. var and same as argements inside "SafariDriver()" as "SafariDriver(options)"

        driver.get("https://www.redbus.in/");


    }
}
