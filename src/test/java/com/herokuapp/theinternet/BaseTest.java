package com.herokuapp.theinternet;

import static com.herokuapp.theinternet.TestData.CHROME_DRIVER_FILE;
import static com.herokuapp.theinternet.TestData.FF_DRIVER_FILE;
import static com.herokuapp.theinternet.TestData.WEB_DRIVER_CHROME;
import static com.herokuapp.theinternet.TestData.WEB_DRIVER_FIRE_FOX;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest
{
    public static WebDriver driver;


    @BeforeTest
    public static void setupTest() {
//        System.out.println("Loading driver from: " + CHROME_DRIVER_FILE);
//        System.setProperty(WEB_DRIVER_CHROME, CHROME_DRIVER_FILE.toString());
//        driver = new ChromeDriver();
        System.out.println("Loading driver from: " + FF_DRIVER_FILE);
        System.setProperty(WEB_DRIVER_FIRE_FOX, FF_DRIVER_FILE.toString());

        driver = new FirefoxDriver();
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
        System.out.println("Test finished");
    }

    public void sleep(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            Logger.getLogger("Error").info("Failed to sleep: " + millis + " millis");
        }
    }

}
