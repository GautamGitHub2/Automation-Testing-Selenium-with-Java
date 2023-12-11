package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.sql.*;
import java.time.Duration;

public class DatabaseTesting {
    public static void main(String[] args) throws SQLException {

        //Data
        String cust_firstname="Gautam";
        String cust_lastname="Kumar";
        String cust_email="gkumar@gmail.com";
        String cust_telPhone="21232345";
        String cust_password="gkumar@123";

        //User Registration
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/opencart/upload/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

        // After this step user will get registration form

        //now at the registration form i have to inspect the elements and enter the values by sendKeys method

        driver.findElement(By.name("firstname")).sendKeys(cust_firstname);
        driver.findElement(By.name("lastname")).sendKeys(cust_lastname);
        driver.findElement(By.name("email")).sendKeys(cust_email);
        driver.findElement(By.name("telephone")).sendKeys(cust_telPhone);
        driver.findElement(By.name("password")).sendKeys(cust_password);
        driver.findElement(By.name("confirm")).sendKeys(cust_password);
        driver.findElement(By.name("agree")).sendKeys(cust_firstname);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        //After this when the registration will be successful one success msg "Your Account Has Been Created" will display at the page, so we have to verify that msg as well.

        try
        {
            String confmsg=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();

            if(confmsg.equals("Your Account Has Been Created!"))
            {
                System.out.println("Registration successful from the UI/Application");
            }else
            {
                System.out.println("Registration Not successful");
            }

        }catch (Exception e)
        {
            System.out.println("Some problem in the application");
        }

        //Record has been inserted to the database by the front end application, now we have to verify this record in database by the selenium

        //Database validation
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop","root","MyN3wP4ssw0rd");
        Statement stmt=con.createStatement();
        String query="select firstname,lastname,email,telephone from oc_customer";
        ResultSet rs=stmt.executeQuery(query);

        boolean status=false;

        while (rs.next()) //we are using while loop here because we don't know the numbers of row here in database
        {
            String firstname=rs.getString("firstname");
            String lastname=rs.getString("lastname");
            String email=rs.getString("email");
            String telephone=rs.getString("telephone");

                    if (cust_firstname.equals(firstname)
                     && cust_lastname.equals(lastname)
                     && cust_email.equals(email)
                     && cust_telPhone.equals(telephone))
            {
                System.out.println("Record found in the table || Test Passed");
                status=true;
                break;// if the mentioned record found then immediately it will break the look and come out of while loop, elese if i do not keep the break statement then it will continue checking for the next record.
            }
        }
        if (status==false)//if record is not found then still the status will be false and in this condition this if condition will be executed "Record Not Found || Test Failed"
        {
            System.out.println("Record Not Found || Test Failed");
        }

    }
}
