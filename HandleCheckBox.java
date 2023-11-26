package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class HandleCheckBox {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        driver.get("https://itera-qa.azurewebsites.net/home/automation");

        //1. Select Specific Check Box
        //driver.findElement(By.xpath("//input[@id='monday']")).click();//Monday Checkbox

        //2. Select all the check boxes
        List<WebElement>checkboxes =driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total number of checkboxes:"+checkboxes.size());

        //Using for loop
        /*
        for (int i=0;i<=checkboxes.size();i++)
        {
            checkboxes.get(i).click();
        }*/

        // Using for..each loop

        /*for(WebElement chbox:checkboxes)
        {
            chbox.click();
        }*/

        // Select multiple check boxes by choice
        //Monday & Sunday i want to select
        for(WebElement chbox:checkboxes)
        {
            String CheckBoxName=chbox.getAttribute("id");
            if (CheckBoxName.equals("monday")|| CheckBoxName.equals("sunday"))
            {
                chbox.click();
            }
        }
        //4. Select Last 2 check boxes
        /*
        Here logic behind this is that i have 7 elements/checkboxes (starting from 0: 0,1,2,3,4,5,6) and i want to check/select last 2 checkboxes then in this case 7-2=5 so 5th would be the starting point to select the checkbox means i have to start selecting the checkbox 5th and 6th

         */
        //Total number of check boxes-number of checkboxes i want to select=starting index
        //7-2=5

        int totalCheckboxes=checkboxes.size();
        /*for (int i=totalCheckboxes-2;i<totalCheckboxes;i++)//for last 3 checkboxes just keep it like "for (int i=totalCheckboxes-3;i<totalCheckboxes;i++)"
        {
            checkboxes.get(i).click();
        }*/

        //5 Select First 2 Check boxes
        for (int i=0;i<totalCheckboxes;i++)
        {
            if (i<2)
            {
            checkboxes.get(i).click();
            }

        }
}}
