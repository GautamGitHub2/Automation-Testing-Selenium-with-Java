package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class KeyboardAction {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("http://the-internet.herokuapp.com/key_presses");

        // here for coding i want to press the key through selenium automation scripts not from the physical keyboard in laptop (MacBook) or external keyboard
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        System.out.println("Successfully ENTER Key Pressed");//Successfully ENTER Key Pressed

        act.sendKeys(Keys.ARROW_DOWN).perform();
        System.out.println("Successfully ARROW_DOWN Key Pressed");//Successfully ARROW_DOWN Key Pressed

        act.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Successfully BACK_SPACE Key Pressed");//Successfully BACK_SPACE Key Pressed

        act.sendKeys(Keys.TAB).perform();
        System.out.println("Successfully TAB Key Pressed");//Successfully TAB Key Pressed

        act.sendKeys(Keys.SHIFT).perform();
        System.out.println("Successfully SHIFT Key Pressed");//Successfully SHIFT Key Pressed
    }
}
