package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class FindElementVsFindElements {

    public static void main(String [] args) {

        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        driver.get("https://demo.nopcommerce.com/");

        //findElement() --> Returns single web element

        //Scenario-1
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchbox.sendKeys("Gautam Kumar");

        //Scenario-2
        //div[@class='footer-upper']//a --> 22 element
        WebElement ele1=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(ele1.getText()); //returned "Sitemap" which is 1st element out of 22 elements, means here i am giving multiple web elements xpath but findElement will return only one (1st) element at a time

        //Scenario-3
        //*[@id="small-search-box-form"]/button --> 1 match
        //button[normalize-space()='Search'] --> 1 match
       //both are correct xPath pointing same search button
        WebElement searchButton=driver.findElement(By.xpath("//*[@id='small-search-box-form']/button"));
        System.out.println(searchButton.getText());//Search --> working as expected

        WebElement searchButton0=driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        System.out.println("searchButton0:"+searchButton0.getText());// searchButton0:Search --> both xPath are fine

        //now in place of "//*[@id='small-search-box-form']/button" i am giving "//*[@id='small-login-box-form']/button"

        //WebElement searchButton1=driver.findElement(By.xpath("//*[@id='small-login-box-form']/button"));
        //System.out.println(searchButton1.getText());//NoSuchElementException --> since login is not available

        //findElements() --> Returns multiple web elements

        //Scenario-1: xPath of the multiple elements and i am accessing it through findElements
        List <WebElement> mulElements=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("Number of elements captured:"+mulElements.size());//Number of elements captured:22

        //Scenario-2: xPath of the single web element but i am accessing it through findElements
        List <WebElement> logo=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println("Number of elements captured:"+logo.size());//Number of elements captured:1

        //Scenario-3: xPath of the multiple elements and i am accessing it through findElements, now trying to that all the elements to perform some set of actions
        List <WebElement> mulElements1=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));//with the findElemets() method if the locator is not finding any matching values from the xPath then it will return 0
        System.out.println("Number of elements captured:"+mulElements1.size());//Number of elements captured:22

        for(WebElement ele:mulElements1)
        {
            System.out.println(ele.getText());
        }
        /*
        Sitemap
        Shipping & returns
        Privacy notice
        Conditions of Use
        About us
        Contact us
        Search
        News
        Blog
        Recently viewed products
        Compare products list
        New products
        My account
        Orders
        Addresses
        Shopping cart
        Wishlist
        Apply for vendor account
        Facebook
        Twitter
        RSS
        YouTube
        */

        //Scenario-4: xPath of the invalid web element means web element is not present in the page
        List <WebElement> mulElements2=driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
        System.out.println("Number of elements captured:"+mulElements2.size());//Number of elements captured:0

    }
}
