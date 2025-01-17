package org.test.my_app_test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        System.out.println( "Hello World!" );
       // WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver()
        //open URL from test server
        // create arguments to fill out the form on the webpage
        //run mvn clean package assembly:single

        driver.get("http://54.173.179.159:8081/contact.html");

//        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        
        driver.findElement(By.name("your_name")).sendKeys("Jennifer");
        driver.findElement(By.name("phone_number")).sendKeys("7132564458");
        driver.findElement(By.name("email_address")).sendKeys("Jechava1@gmail.com");
        driver.findElement(By.name("your_message")).sendKeys("Hi, How are you?");
        driver.findElement(By.id("my-button")).click();
        
        String message= driver.findElement(By.id("response")).getText();
        
        System.out.println(message);

        //capture screenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        
        File destFile= new File("test-report.jpg");
        
        FileUtils.copyFile(srcFile,destFile);
        
        driver.quit();
        
        System.out.println("Script executed and results captured");
//        System.out.println(getClass().getResource("/foo/bar/Baz.class"));
    }
}
