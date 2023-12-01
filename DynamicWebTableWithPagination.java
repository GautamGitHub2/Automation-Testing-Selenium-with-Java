package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DynamicWebTableWithPagination {

    //********* Very-very important concepts...This code is 100% perfect, it may be vary due to xPath of the new version of this website/we pages ********

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        //Login
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.clear();
        username.sendKeys("demo");

        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.clear();
        password.sendKeys("demo");

        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        //Close Pop-up --> this is available in latest version of the webpage, Pop-ups are not coming in old version of the page when this topic was discussed/taught by the tutor.

        //Sales --> Orders
        driver.findElement(By.xpath("//div//a[text()=' Sales']")).click();
        driver.findElement(By.xpath("//div//a[text()='Orders']")).click();

        //Table

        //1) Find the total number of pages in table
        String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
        System.out.println(text); // showing 1 to 20 of 8511 (426 pages)

        // Simple logic/method to print total number of pages i.e. 426

        int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
        System.out.println("Total Number of pages"+total_pages);// 426


        //2. Find how many rows exists in each pages
        for(int p=1;p<=total_pages;p++) // hard code to reduce the total_pages (5) since here in this case total_pages are 426
        {
            WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("Active Page:"+active_page.getText());
            active_page.click();
            // When i click on the particular page number of the dynamic table, it will become 'Active Page' and rest pages will be as acnchor page 'a'

            int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();// it will capture the multiple rows from the dynamic table
            System.out.println("Number of rows:"+rows);// it will give the total numbers of the rows in selected page /'active page' number

            //3. Read all the rows data from each page
            for (int r=1;r<=rows;r++)//Hard code to reduce the number of rows (5) since here in this case rows are 20 in each pages (total pages are 426)
            {
                String orderId=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
                String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
                String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();

                System.out.println(orderId+"      "+customerName+"      "+status);

                //4. Print the 'orderId', 'customerName' if the 'status'='Pending'

                /*if (status.equals("Pending"))
                {
                    System.out.println(orderId+"      "+customerName+"      "+status);
                }*/
            }

            // Now logic for, if user is at 1st active page and have calculated the rows from that active page then 'how to move to next active page i.e. 2nd page'? and get the rows from that page...and so on till 426 pages, so for this i have to pass the dynamic values of next page inside the xPath and have to perform click() so that it will become active page

            String pageno=Integer.toString(p+1);
            driver.findElement(By.xpath("//ul[@clas='pagination']//li//a[text()='"+pageno+"']")).click();
        }
    }
}
