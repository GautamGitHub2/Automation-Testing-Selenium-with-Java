package SeleniumWithJavaProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DownloadPDFFile {
    public static void main(String[] args) {
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();

         /*
        But my requirement to save the file in Download folder, it should not open in same browser, so for this below code is...

        the mentioned requirement can be completed in Chrome, Edge and Firefox Browser... since i cannot see the setPreferences methods..
        .
        .
        .
        String downloadLocation=System.getProperty("/Users/gautamkumar/Documents/Gautam_MacBookAir/My Documents/Study_Trainings_Interviews/Quality Assurance Study/Automation Testing/Selenium with Java Automation Testing/Selenium_with_Java_Projects_IntelliJ/Selenium/Downloads");
        HashMap preferences=new HashMap();
        preferences.put("download.default_directory",downloadLocation);

        SafariOptions options=new SafariOptions();
        options.setExperimentalOption("prefs",preferences);
        .
        .
        .
        */

        /*
        Chrome Browser...

        String location=System.getProperty("user.dir")+"\\Downloads\\";
        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true);// for PDF download
        preferences.put("download.default_directory",downloadLocation);

        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",preferences);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);

        //Edge: below code is for Windows application

        String location=System.getProperty("user.dir")+"\\Downloads\\";
        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true);// for PDF download
        preferences.put("download.default_directory",downloadLocation);

        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("prefs",preferences);

        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver(options);

        //Firefox: below code is for Windows application

        As soon as the download link button got clicked, one window pop-up will come in firefox to avoid this window pop-up below code is there.

        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("pdfjs.disabled",true);//only for pdf file
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); // here 'application/msword' has been kept in place of 'value' section of the method 'setPreference' and this is kind of 'mime type' of the file and the mine types are available for firefox at "sitepoint.com/mime-types-complete-list/"
        profile.setPreference("browser.download.folderList",2);// 0- desktop, 1- default Download folder, 2- desired location
        profile.setPreference("browser.download.dir", downloadLocation)

        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver(options);

        */

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a")).click();//working as expected, PDF file opened as view in same browser

    }
}
