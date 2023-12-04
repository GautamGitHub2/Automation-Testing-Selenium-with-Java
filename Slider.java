package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class Slider {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        //Min_Slider
        WebElement min_slider= driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));

        System.out.println("Location of the min_slider:"+min_slider.getLocation()); //Location of the min_slider:(59, 250)
        System.out.println("Height & Width of the Element (Size of the min_slider):"+min_slider.getSize());//Height & Width of the Element (Size of the min_slider):(21, 21)

        Actions act=new Actions(driver);
        act.dragAndDropBy(min_slider,100,0).perform();

        System.out.println("After Movement Location of the min_slider:"+min_slider.getLocation());//After Movement Location of the min_slider:(160, 250)
        System.out.println("After Movement Height & Width of the Element (Size of the min_slider):"+min_slider.getSize());//After Movement Height & Width of the Element (Size of the min_slider):(21, 21)

        //Max Slider
        WebElement max_slider= driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));

        System.out.println("Location of the max_slider:"+max_slider.getLocation());//Location of the max_slider:(325, 250)
        System.out.println("Height & Width of the Element (Size of the max_slider):"+max_slider.getSize());//Height & Width of the Element (Size of the max_slider):(21, 21)

        act.dragAndDropBy(max_slider,-100,0).perform();

        System.out.println("After Movement Location of the max_slider:"+max_slider.getLocation());//After Movement Location of the max_slider:(224, 250)
        System.out.println("After Movement Height & Width of the Element (Size of the max_slider):"+max_slider.getSize());//After Movement Height & Width of the Element (Size of the max_slider):(21, 21)

    }
}
