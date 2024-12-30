package org.test.my_app_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement username = driver.findElement(By.name("email"));
        WebElement password=driver.findElement(By.name("pass"));

        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        Thread.sleep(2000);

        username.sendKeys("jechava1");
        Thread.sleep(2000);
        password.sendKeys("password");
        Thread.sleep(1000);

        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.id("message"));
       // message.getText();
        System.out.println(message.getText());

        driver.quit();
    }
}
