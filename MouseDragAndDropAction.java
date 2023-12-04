package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class MouseDragAndDropAction {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        //Source (Capitals of the Countries)
        WebElement Oslo=driver.findElement(By.id("box1"));
        WebElement Stockholm=driver.findElement(By.id("box2"));
        WebElement Washington=driver.findElement(By.id("box3"));
        WebElement Capetown=driver.findElement(By.id("box4"));
        WebElement Seoul=driver.findElement(By.id("box5"));
        WebElement Rome=driver.findElement(By.id("box6"));
        WebElement Madrid=driver.findElement(By.id("box7"));

        //Target (Name of the Countries )
        WebElement Norway=driver.findElement(By.id("box101"));//Target (Country name)
        WebElement Sweden=driver.findElement(By.id("box102"));
        WebElement United_States=driver.findElement(By.id("box103"));
        WebElement Denmark=driver.findElement(By.id("box104"));
        WebElement South_Korea=driver.findElement(By.id("box105"));
        WebElement Italy=driver.findElement(By.id("box106"));
        WebElement Spain=driver.findElement(By.id("box107"));

        Actions act=new Actions(driver);
        act.dragAndDrop(Oslo,Norway).perform();
        act.dragAndDrop(Stockholm,Sweden).perform();
        act.dragAndDrop(Washington,United_States).perform();
        act.dragAndDrop(Capetown,Denmark).perform();
        act.dragAndDrop(Seoul,South_Korea).perform();
        act.dragAndDrop(Rome,Italy).perform();
        act.dragAndDrop(Madrid,Spain).perform();

        System.out.println("This Code is working as expected..!!");//This Code is working as expected..!!

        //100% executed correctly, here it is matching the capitals of the country so if i take a source (capital) and try to match with the wrong country name then it will give error

    }
}
