package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import java.util.List;

public class BootstrapDropDown {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        // here i am expalianing about the HDFC bank

        driver.get("https://www.hdfcbank.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();

        //Product Types
        List<WebElement> productTypes=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

        System.out.println("Number of options:"+productTypes);//14

        for (WebElement ptype:productTypes)
        {
            if(ptype.getText().equals("Account"))
            {
                ptype.click();
                break;
            }
        }

        //Product
        driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
        List<WebElement> products=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));

        System.out.println("Number of options:"+products);

        for (WebElement product:products)
        {
            if(product.getText().equals("Salary Acounts"))
            {
                product.click();
                break;
            }
        }

        //These are the methods for each values inside the drop down this is long process so to minimize this we should write the generic method that will be applicable for all the drop downs and all the values inside the drop down
        // this has been explained in below code/BootStrapDropDownGenericMethod












        /* this example is for ICICI bank.... will try once again...
        driver.get("https://www.icicibank.com/homepage");
        driver.findElement(By.xpath("//*[@id='intSelectOne-button']"));

        List<WebElement> selectProductTypes=driver.findElements((By.xpath("//ul[@id=‘intSelectOne-menu’]/li")));
        System.out.println("Number of options:"+selectProductTypes.size());

        //*[@id="intSelectOne-button"]/span[2] --> this is for 1st item Select
        //*[@id="ui-id-3"]
        //*[@id="intSelectOne-button"]/span[2]
        //*[@id="intSelectOne"]/option[2]
        //*[@id="intSelectOne-button"]/span[1]
        //ul[@id=‘intSelectOne-menu’]/li —> Select Menu list items

        //*[@id="intSelectOne-button"]


         */









    }
}
