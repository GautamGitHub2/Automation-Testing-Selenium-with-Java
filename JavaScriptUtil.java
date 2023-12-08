package SeleniumWithJavaProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {


    //Here all methods are static method and reason behind this we can static method by help of the class name, whenever we required these methods...

    public static void drawBorder(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js= ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'",element); //argument[0].style.border='3px solid red' --> this is the argument that will be passed through JavascriptExecutor, here 3px-> is the thickness of the border and border color is red
    }

    public static String getTitleByJS(WebDriver driver)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        String title=js.executeScript("return document.title;").toString();
        return title;
    }

    public static void clickElementByJS(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();",element);
    }

    public static void generateAlert(WebDriver driver,String message)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("alert(' "+message+" ')");
    }

    public static void refreshBrowserByJS(WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static void scrollPageDown(WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//document.body.scrollHeight --> This is representing end of the page
    }

    public static void scrollPageUp(WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");// -document.body.scrollHeight --> This is representing upper portion of the page
    }

    public static void zoomPageByJS(WebDriver driver)
    {
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("document.body.style.zoom='150%'"); //zoom in by 150%
    }

    public static void flash(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        String bgcolor= element.getCssValue("backgroundColor");
        for (int i=0; i<10; i++)
        {
            changeColor("#000000",element,driver);//1
            changeColor(bgcolor,element,driver);//2
        }
    }
    public static void changeColor(String color,WebElement element,WebDriver driver)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = ' "+color+" ' ", element);

        try
        {
            Thread.sleep(20);
        }catch (InterruptedException e)
        {

        }

    }


}
