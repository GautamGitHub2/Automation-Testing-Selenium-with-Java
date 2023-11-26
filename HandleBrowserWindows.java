package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import javax.security.auth.login.AccountLockedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //getWindowHandle()
        String windowID=driver.getWindowHandle();//return ID of the single browser window
        System.out.println(windowID);//page-96FA193D-C16E-45F5-8D1A-ACB8D18E5528
                                     //page-F346AF66-7420-4C56-B140-3BD9DD3BD26C
                                     // Everytime the windowId will be different
        //driver.wait(3000);

        //getWindowHandles()

        WebElement textArea=driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")); //By xPath: //a[text()='OrangeHRM, Inc']
        //WebElement textArea=driver.findElement(By.xpath("//div[@id='app']//a[text()='OrangeHRM, Inc']"));
        //div[@id="app"]//a[text()="OrangeHRM, Inc"]
        //Actions build=new Actions(driver);//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a
        //build.moveToElement(textArea).build().perform();
        Thread.sleep(3000);
        textArea.click();

        Set<String> windowIDs=driver.getWindowHandles();//return Ids of multiple browser windows; Duplicates are not allowed

        // First method - iterator()

        /*Iterator<String> it=windowIDs.iterator();
        String parentWindowID=it.next();
        String childWindowID=it.next();

        System.out.println("Parent Window ID:"+parentWindowID);
        System.out.println("Child Window ID:"+childWindowID);*/

        //Second Method - using List/ArrayList
        List<String> windowIDsList = new ArrayList(windowIDs); //Duplicates are allowed, here we have to convert Set into List just i have to pass reference variable (windowIDs) of Set inside ArrayList (windowIDs)

        /* String parentWindowID= windowIDsList.get(0); //parent Window ID
        String childWindowID= windowIDsList.get(1); //child Window ID

        System.out.println("Parent Window ID:"+parentWindowID);
        System.out.println("Child Window ID:"+childWindowID);

        //How to use window ID's for switching

        driver.switchTo().window(parentWindowID);
        System.out.println("Parent window Title:"+driver.getTitle());

        driver.switchTo().window(childWindowID);
        System.out.println("Child window Title:"+driver.getTitle());
        */

        //For each loop

        /*for (String winId:windowIDsList)
        {
            //System.out.println(winId);
            String title=driver.switchTo().window(winId).getTitle();
            System.out.println(title);
        }*/
        //driver.close();//close the single browser window which is pointing the child window
        //driver.quit();//quit all the opened browser

        //how to close the window by choice

        for (String winId:windowIDsList)
        {
            String title=driver.switchTo().window(winId).getTitle();
            if(title.equals("OrangeHRM"))
            {
                driver.close();
            }
        }
    }
}
