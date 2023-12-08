package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.Script;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Syntax
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript(Script,args);

        /*
        Here logic behind the Type Casting of (JavascriptExecutor) driver;
        WebDriver is an interface and JavascriptExecutor is also an interface, so we cannot directly assign the variable of WebDriver to the JavascriptExecutor
        for assigning this we need to do the type casting.

        and if we do the with SafariDriver in place of WebDriver then no need to type cast.

        in JavascriptExecutor we have a method called executeScript() and with the help of this we can execute the JavaScript Statement
        */

        // Flash -> it is used to flash an item again and again to highlight something
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.flash(logo,driver);



        // Drawing border & take screenshot-> it is used to highlight an item like highlight something in screenshot, an item, button..etc by adding some border...we can draw the border
        // in this scenario i am taking logo as an element and draw the border

        /*
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.drawBorder(logo,driver);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/gautamkumar/Documents/Gautam_MacBookAir/My Documents/Study_Trainings_Interviews/Quality Assurance Study/Automation Testing/Selenium with Java Automation Testing/Selenium_with_Java_Projects_IntelliJ/Selenium/Screenshots/logoWithBorder.png");
        FileUtils.copyFile(src,trg); // Working as expected
         */

        // Getting title of the page by JavascriptExecutor
        /*
        String title=JavaScriptUtil.getTitleByJS(driver);
        System.out.println(title);//nopCommerce demo store
         */

        // To perform click operation we can use JavascriptExecutor

        /*
        WebElement RegisterLink=driver.findElement(By.xpath("//a[@class='ico-register']"));
        JavaScriptUtil.clickElementByJS(RegisterLink,driver);//working as expected
        */

        // Generate an alert
        //JavaScriptUtil.generateAlert(driver,"This is My Alert..!!");// Working as expected

        // Refresh the page
        //JavaScriptUtil.refreshBrowserByJS(driver);

        //Scroll down/up the page

        /*
        JavaScriptUtil.scrollPageDown(driver); //Working as expected
        Thread.sleep(5000);

        JavaScriptUtil.scrollPageUp(driver); //Working as expected
         */

        // Zoom in/out the page
        //JavaScriptUtil.zoomPageByJS(driver);

        /*
        All the above mentioned functionalities will be performed by the JavascriptExecutor, for these activities we can create an reusable 'utility' file so that these can be performed one by one by using this file.
        means, whenever required just call this utility file and use the required function like: 'Flash', 'Drawing border & take screenshot'...etc.
        */



    }
}
