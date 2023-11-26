package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class getTextVSgetAttribute {
    public static void main(String [] args) {

        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        driver.get("https://admin-demo.nopcommerce.com/login");


        WebElement emailInputBox=driver.findElement(By.id("Email"));

        /*
        emailInputBox.clear();
        emailInputBox.sendKeys("kr1102gautam@gmail.com");//Successfully Entered the email into the emailInputBox

        //input[@id="Email"]

         */
        //Now want to capture the existing values that is by default entered in emailInputBox

        // Capturing text values from email input box
        System.out.println("Results from getAttribute() method:"+emailInputBox.getAttribute("value"));//Results from getAttribute() method:admin@yourstore.com

        System.out.println("Results from getText() method:"+emailInputBox.getText());//Results from getText() method: --> Nothing displayed

        /*
        Here are the difference between getAttribute() and getText() methods
        just understand with the below example:

        some HTML code i have

        <input name="email" id="user" value="admin@yourstore.com">abc@gmail.com</input> [here abc@gmail.com is inner text]

        getAttribute()--> method fetches the text contained by an attribute in an HTML document.
        getAttribute("name") --> email [this will be output of the getAttribute() method]
        getAttribute("id") --> user
        getAttribute("value") --> admin@yourstore.com

        getText() --> abc@gmail.com; this method is used to capture the inner text of an element

        if inner text is not available then it will not return anything, it will be empty
        */

        //Login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        System.out.println(loginButton.getAttribute("type"));//submit
        System.out.println(loginButton.getAttribute("class"));//button-1 login-button

        System.out.println(loginButton.getText());//Log in

        //div[@class='page-title']//h1 --> this is customized xPath // learn and make grip on it 'How to take customize xPath?'

        String titleOfThePage = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
        System.out.println(titleOfThePage);//Admin area demo

    }
}
