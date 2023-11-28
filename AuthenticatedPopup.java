package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AuthenticatedPopup {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();
        String URL="http://admin:admin@the-internet.herokuapp.com/basic_auth";
        driver.get(URL); // As soon as i open this URL it will show the authentication (Username and Password) pop-up to login in to the web page. And until and unless i enter the correct username and password i will not able to land to the webpage/home page
        // this url is working as expeced in chrome driver

        //driver.get("http:the-internet.herokuapp.com/basic_auth");

        //Syntax
        //https://user:password@URL
        //https://admin:admin@the-internet.herokuapp.com/basic_auth
    }
}
