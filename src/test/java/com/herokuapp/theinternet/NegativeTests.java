package com.herokuapp.theinternet;

        import static com.herokuapp.theinternet.TestData.FAKE_USER_NAME;
        import static com.herokuapp.theinternet.TestData.FAKE_USER_PASSWORD;
        import static com.herokuapp.theinternet.TestData.USER_PASSWORD;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class NegativeTests extends BaseTest
{

    @Test
    public void incorrectUserNameTest()
    {
        System.out.println("Starting incorrect user name test.");

        // maximize browser window
        driver.manage().window().maximize();

        // open test url
        String testUrl = "https://the-internet.herokuapp.com/login";
        driver.get(testUrl);
        System.out.println("Page url \"" + testUrl + "\" was opened.");
        sleep(1000);

        // enter user name
        WebElement userName = driver.findElement(By.id("username"));
        String incorrectUserName = FAKE_USER_NAME;
        userName.sendKeys(incorrectUserName);
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
        // same url verification
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(testUrl, actualUrl,
                "Actual page url is not the same as expected");

        // login button available
        WebElement loginButtonReappear = driver.findElement(By.tagName("button"));
        Assert.assertTrue(loginButtonReappear.isDisplayed(), "Login button is not visible");

        // user name is invalid error message
        WebElement successElement = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(successElement.isDisplayed(), "Error message saying user name is invalid is not visible");

        String expectedMessage = "Your username is invalid!";
        String actualMessage = successElement.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message is not the same as expected\n"
                + "Actual message: " + actualMessage + "\nExpected message: " + expectedMessage);

    }

    @Test
    public void incorrectPasswordTest()
    {
        System.out.println("Starting incorrect user name test.");

        // maximize browser window
        driver.manage().window().maximize();

        // open test url
        String testUrl = "https://the-internet.herokuapp.com/login";
        driver.get(testUrl);
        System.out.println("Page url \"" + testUrl + "\" was opened.");
        sleep(1000);

        // enter user name
        WebElement userNameElement = driver.findElement(By.id("username"));
        String userName = "tomsmith";
        userNameElement.sendKeys(userName);
        sleep(1000);

        // enter password
        WebElement incorrectPassword = driver.findElement(By.name("password"));
        incorrectPassword.sendKeys(FAKE_USER_PASSWORD);
        sleep(1000);

        // click login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        sleep(1000);

        // verifications
        // same url verification
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(testUrl, actualUrl,
                "Actual page url is not the same as expected");

        // login button available
        WebElement loginButtonReappear = driver.findElement(By.tagName("button"));
        Assert.assertTrue(loginButtonReappear.isDisplayed(), "Login button is not visible");

        // user name is invalid error message
        WebElement successElement = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(successElement.isDisplayed(), "Error message saying user password is invalid is not visible");

        String expectedMessage = "Your password is invalid!";
        String actualMessage = successElement.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message is not the same as expected\n"
                + "Actual message: " + actualMessage + "\nExpected message: " + expectedMessage);

    }
}
