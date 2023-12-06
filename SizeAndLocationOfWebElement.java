package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class SizeAndLocationOfWebElement {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.opencart.com");
        driver.manage().window().maximize();

        WebElement logo=driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']"));

        //location - method-1
        System.out.println("Location(x,y):"+logo.getLocation());//Location(x,y):(165, 21)
        System.out.println("Location(x):"+logo.getLocation().getX());//Location(x):165
        System.out.println("Location(y):"+logo.getLocation().getY());//Location(y):21

        //location - method-2
        System.out.println("Location(x):"+logo.getRect().getX());//Location(x):165
        System.out.println("Location(y):"+logo.getRect().getY());//Location(y):21

        //Size - method -1
        System.out.println("Size(Width,Height):"+logo.getSize());//Size(Width,Height):(185, 36)
        System.out.println("Size(Width):"+logo.getSize().getWidth());//Size(Width):185
        System.out.println("Size(Height):"+logo.getSize().getHeight());//Size(Height):36

        //Size - Method -2
        System.out.println("Size(Width):"+logo.getRect().getDimension().getWidth());//Size(Width):185
        System.out.println("Size(Height):"+logo.getRect().getDimension().getHeight());//Size(Height):36

        driver.close();

    }
}
