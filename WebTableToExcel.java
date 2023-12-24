package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

public class WebTableToExcel {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

        //driver.wait(5000);
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");

        String path=".//DataFiles//CountriesPopulation.xlsx";
        XLUtility xlutil=new XLUtility(path);

        //Write headers in excel sheet

        xlutil.setCellDataFinal("Sheet 1",0,0,"Country");
        xlutil.setCellDataFinal("Sheet 1",0,1,"Population");
        xlutil.setCellDataFinal("Sheet 1",0,2,"% of world");
        xlutil.setCellDataFinal("Sheet 1",0,3,"Date");
        xlutil.setCellDataFinal("Sheet 1",0,4,"Source");

        //capture table rows
        WebElement table=driver.findElement(By.xpath("//table[@class='wikitable sortable sticky-header col2left col6left jquery-tablesorter']/tbody"));

        //WebElement tr=driver.findElements(By.xpath("//table[@class='wikitable sortable sticky-header col2left col6left jquery-tablesorter']/tbody/tr"))

        int rows=table.findElements(By.xpath("tr")).size();// rows present in web table & This is another approach to take the tr xpath since table xpath has already been taken

        for (int r=1;r<rows;r++)
        {
            //read data from web table
            String country=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
            String population=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
            String perOfWorld=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
            String date=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
            String source=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();

            System.out.println(country+" "+population+" "+perOfWorld+" "+date+" "+source);

            //writing the data in excel sheet

            xlutil.setCellDataFinal("Sheet 1",r,0,country);
            xlutil.setCellDataFinal("Sheet 1",r,1,population);
            xlutil.setCellDataFinal("Sheet 1",r,2,perOfWorld);
            xlutil.setCellDataFinal("Sheet 1",r,3,date);
            xlutil.setCellDataFinal("Sheet 1",r,4,source);
        }
        System.out.println("Web Scrapping done successfully..!!");
        driver.close();

        //xPath of the web table is: table[@class="wikitable sortable sticky-header col2left col6left jquery-tablesorter"]/tbody

    }
}
