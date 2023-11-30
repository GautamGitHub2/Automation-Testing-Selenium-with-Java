package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
Q. How to find, how many rows in table?
Q. How many columns in a table?
Q. Retrieve the specific row/column data.
Q. Retrieve all the data from the table.
Q. Print Release Date, Version Number of Java Language of Selenium.
*/

public class WebTable1 {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        //1. How many rows in a table
        int rows=driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
        System.out.println("Total number of rows in a table:"+rows);

        //1. How many columns in a table
        int cols=driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th")).size();
        System.out.println("Total number of columns in a table:"+cols);

        //3. Retrieve the specific row/column data
        String value=driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();
        System.out.println("The value is:"+value);

        //4. Retrieve all the data from the table.
        /*
        For this activity i have to write 2 for loops, 1st for loop (outer for loop) will retrieve the data from the row and 2nd for loop (inner for loop) will retrieve for column.
        after that for the inner for loop i will have to parameterize the xPath of the data what i am going to retrieve by this for loop
         */
        System.out.println("Data from the table........");
        for(int r=1;r<=rows;r++)
        {
            for(int c=1;c<=cols;c++)
            {
                String data=driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
                System.out.println("The data is:"+data+"     ");
            }
            System.out.println();
        }

        //5. Print Release Date, Version Number of Java Language of Selenium.

        for (int r=1;r<=rows;r++)
        {
            String language=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[1]")).getText();
            if(language.equals("Java"))
            {
                String version_number=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[2]")).getText();
                String released_date=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+r+"]/td[3]")).getText();
                System.out.println(language+"   "+version_number+"   "+released_date);
            }
        }
        driver.quit();
    }
}
