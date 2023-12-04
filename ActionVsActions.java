package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class ActionVsActions {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement features=driver.findElement(By.xpath("//a[@title='Women']"));

        Actions act=new Actions(driver);
        //ct.moveToElement(features).perform();

        Action action=act.moveToElement(features).build();

        /*
        public Action build()
        {
        Action toReturn = new BuiltAction(driver, new LinkedHashMap<>(sequences));
        sequences.clear();
        return toReturn;
        }
        */

        action.perform();

        /*
         public void perform()
         {
         build().perform();
         }
        */

    }
}
