package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Alert window with OK button
        /*

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();//You successfully clicked an alert--> Displayed at website/web page

        */

        //Alert window with OK & Cancel button
        //button[text()="Click for JS Confirm"]

       /*

       driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
       Thread.sleep(3000);
       //driver.switchTo().alert().accept();// You clicked: OK
       driver.switchTo().alert().dismiss();//You clicked: Cancel

Click for JS Prompt
        */

        //Alert window with input box, capture text from alert

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        Alert alertWindow=driver.switchTo().alert();
        System.out.println("The Message displayed on alert:"+alertWindow.getText());//The Message displayed on alert:I am a JS prompt
        alertWindow.sendKeys("Gautam");//You entered: Gautam
        alertWindow.accept();

    }
}
