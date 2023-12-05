package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class KeyboardActionMultipleKeys {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        WebElement text_box_1=driver.findElement(By.name("text1"));
        //textarea[@name="text1"]
        //textarea[@id="inputText1"]
        WebElement text_box_2=driver.findElement(By.name("text2"));

        text_box_1.sendKeys("Hello Gautam!");

        Actions act=new Actions(driver);

        //CTRL + A
        act.keyDown(Keys.COMMAND);
        act.sendKeys("a");
        act.keyUp(Keys.COMMAND);
        act.perform();

        //CTRL + C
        act.keyDown(Keys.COMMAND);
        act.sendKeys("c");
        act.keyUp(Keys.COMMAND);
        act.perform();

        //TAB - Shift to text_box_2
        act.sendKeys(Keys.TAB);
        act.perform();

        //CTRL + V
        act.keyDown(Keys.COMMAND);
        act.sendKeys("v");
        act.keyUp(Keys.COMMAND);
        act.perform();

        //Compare Texts
        if (text_box_1.getAttribute("value").equals(text_box_2.getAttribute("value")))
            System.out.println("Text Copied");//Text Copied
        else
            System.out.println("Text Not Copied");
    }
}
