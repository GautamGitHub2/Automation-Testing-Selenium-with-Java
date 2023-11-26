package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class HandleJQueryDropDown {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.manage().window().maximize();

        driver.findElement(By.id("justAnInputBox")).click();

        //selectChoiceValues(driver,"choice 1");
        //selectChoiceValues(driver,"choice 2","choice 2 3","choice 6", "choice 6 2 1","choice 6 2");//working as expected
        selectChoiceValues(driver,"all"); //working as expected all choices selected
    }

    public static void selectChoiceValues(WebDriver driver,String... value) //here String... can hold all the types of parameters like single choice, multiple choice or all as mentioned above
    {
       List<WebElement> choiceList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

        //span[@class='comboTreeItemTitle'] --> 44 matches
        if (!value[0].equalsIgnoreCase("all"))
        {
            for (WebElement item:choiceList)
            {
                String text=item.getText();
                for (String val:value)
                {
                    if(text.equals(val))
                    {
                        item.click();
                        break;
                    }
                }
            }
        }
        else
        {
            try
            {
            for (WebElement item:choiceList)
            {
                item.click();

            }
        }catch (Exception e)
            {
                System.out.println("Exceptions are Here...");

            }

    }
}}
