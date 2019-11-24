package com.herokuapp.theinternet;

import static com.herokuapp.theinternet.TestData.USER_NAME;
import static com.herokuapp.theinternet.TestData.USER_PASSWORD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests extends BaseTest
{
    @Test
    public void loginTest()
    {
        System.out.println("Starting login test.");

        // maximize browser window
        driver.manage().window().maximize();

        // open test url
        String testUrl = "https://the-internet.herokuapp.com/login";
        driver.get(testUrl);
        System.out.println("Page url \"" + testUrl + "\" was opened.");
        sleep(1000);

        // enter user name
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(USER_NAME);
        sleep(1000);

        // enter password
        WebElement userPassword = driver.findElement(By.name("password"));
        userPassword.sendKeys(USER_PASSWORD);
        sleep(1000);

        // click login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        sleep(1000);

        // verifications
        // new url verification
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl,
                "Actual page url is not the same as expected");

        // logout button available
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not visible");

        // logged in successful message
        WebElement successElement = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(successElement.isDisplayed(), "Success message is not visible");

        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successElement.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message is not the same as expected\n"
                + "Actual message: " + actualMessage + "\nExpected message: " + expectedMessage);

    }
}
