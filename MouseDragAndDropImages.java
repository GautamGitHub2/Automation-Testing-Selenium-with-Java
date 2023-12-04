package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class MouseDragAndDropImages {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();

        //if the name or id of the iFarme is available then i can directly pass those name or id in double cotation like: driver.findElement(By.id... or By.name)
        // and if the name or id is not present then i have to use below method

        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='post-2669']/div[2]/div/div/div[1]/p/iframe")));


        //*[@id="post-2669"]/div[2]/div/div/div[1]/p/iframe

        //Source Items
        WebElement item1=driver.findElement(By.xpath("//li[1]/img"));
        WebElement item2=driver.findElement(By.xpath("//li[2]/img"));
        //WebElement item3=driver.findElement(By.xpath("//li[3]/img"));
        //WebElement item4=driver.findElement(By.xpath("//li[4]/img"));

        //Target
        WebElement trash=driver.findElement(By.xpath("//div[@id='trash']"));

        //Moved the items into the trash
        Actions act=new Actions(driver);
        act.dragAndDrop(item1,trash).perform();
        act.dragAndDrop(item2,trash).perform();
        //act.dragAndDrop(item3,trash).perform();
        //act.dragAndDrop(item4,trash).perform();







    }
}
