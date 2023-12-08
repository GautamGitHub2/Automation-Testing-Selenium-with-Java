package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Set;

public class HandlingCookies {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://demo.nopcommerce.com/");

        //How to capture cookies from browser
        Set<Cookie> cookies=driver.manage().getCookies(); // here Cookie is the pre-defined class
        System.out.println("Size of Cookies..."+ cookies.size());//5

        //How to print cookies from browser
        for (Cookie cookie:cookies)
        {
            System.out.println(cookie.getName()+" : "+cookie.getValue());
        }

        /*
        Output:
        Size of Cookies...5
        .Nop.Customer : a2f3ad3d-731f-4506-b20d-76c3a59a095c
        _ga : GA1.1.869148566.1702059727
        .Nop.Culture : c%3Den-US%7Cuic%3Den-US
        .Nop.Antiforgery : CfDJ8MN0ldDInNtCgdE20r5hSU5QZvDjy7UTEHToSudzR_oTDD_GRXxZmgf3-maqr_WlL7AObMDFDG4vDKGTE0qjkbuYFDnT4LRbCt0A3kqcES319tK6FFlXbBJGZWJ8uCyMP-EmE1Ud5dYAXT-VQsVcgtc
        _ga_SCT41TW89V : GS1.1.1702059727.1.0.1702059727.0.0.0
         */

        //How to add Cookie to the browser
        Cookie cookieObj=new Cookie("This-Cookie-Is-Added-By-Gautam","GautamKumar12345");
        driver.manage().addCookie(cookieObj);
        cookies=driver.manage().getCookies();
        System.out.println("After Adding Size of Cookies..."+ cookies.size());//6

        //How to delete specific Cookie from the browser
        driver.manage().deleteCookie(cookieObj);
        cookies=driver.manage().getCookies();
        System.out.println("After Deleting Size of Cookies..."+ cookies.size());//5

        //Delete cookies with name
        driver.manage().deleteCookieNamed("This-Cookie-Is-Added-By-Gautam");
        cookies=driver.manage().getCookies();
        System.out.println("After Deleting Size of Cookies..."+ cookies.size());//5

        //How to delete all cookies from the browser
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("After Deleting Size of Cookies..."+ cookies.size());//0

        driver.quit();
    }
}
