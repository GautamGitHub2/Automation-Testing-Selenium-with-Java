package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class UploadFile {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.monsterindia.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();

        /*
        After clicking here one window pop-up will open, and after inspecting this pop-up i found that the id=file-upload , name=file and type=file so in this case i can directly use sendKeys method
        */
        //Using SendKeys()
        //driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("/Users/gautamkumar/Documents/Gautam_MacBookAir/Hello_Gautam.txt");//Working as expected

        //Using Robot Class Method
        /*
        Reason to use this method is if i click "Select file to Upload" then window pop-up will come to select the file, and actually selenium webdriver does not support this so to use this feature we take help from Robot classes/ methods
        * This is windows application and selenium webdriver cannot identify this.
        */
        driver.findElement(By.xpath("//input[@id='file-upload']")).click();

        /*
        This function / Robot Class Method will not be possible in SafariDriver, because i i perform click operation on "Select file to Upload" getting below exception...

        "Exception in thread "main" org.openqa.selenium.InvalidArgumentException: Clicking on an <input type=file> element is not supported. Use sendKeys to select files instead."

        Trying to perform by JavaScript Executor

        */

        WebElement selectFileToUpload=driver.findElement(By.xpath("//input[@id='file-upload']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",selectFileToUpload); // This will perform click action on the selectFileToUpload

        // Above code is not working as expected in Safari...getting below exception
        // Exception in thread "main" org.openqa.selenium.UnhandledAlertException: : Cannot contact reCAPTCHA. Check your connection and try again.

        /*

        //Robot class will work in ChromeDriver [Windows OS]

        Above code will work with Chrome Driver with below additional code...

        After this code [ js.executeScript("arguments[0].click();",selectFileToUpload); ]

        Window pop-up (Browse window) for selecting the file will open...

        now in 'File Name' box we have to pass the location of the file then click on 'Open' button
        so these two keyboard actions will be performed by Robot class...
        for this i have to perform below 3 things...

        1. Copy the path
        2. CTRL + v [Paste the path in 'File Name' box]
        3. Press Enter Key

        Robot rb=new Robot();
        rb.delay(2000);// 1 sec, this is just like the wait method

        //Put path to file in a clipboard
        StringSelection ss=new StringSelection("C:\\SeleniumWithJavaProject\\Hello_Gautam.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null); // Above 2 statements will do CTRL + C operation in Windows OS, so the file will go to the clipboard

        now after the click operation at the button 'selectFileToUpload' the cursor will be waiting at the 'File Name' file location text box and when the copied file come to the clipboard then i have to perform CTRL + V

        //CTRL + V
        rb.keyPress(KeyEvent.VK_CONTROL); // Press on CTRL key
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(2000);

        //Release the Key
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);

        //ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        */
    }
}
