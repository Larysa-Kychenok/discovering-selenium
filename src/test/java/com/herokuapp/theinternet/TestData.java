package com.herokuapp.theinternet;

import java.io.File;

public class TestData
{
    public static final String USER_NAME = "tomsmith";
    public static final String USER_PASSWORD = "SuperSecretPassword!";
    public static final String FAKE_USER_NAME = "fakesmith";
    public static final String FAKE_USER_PASSWORD = "fakeSecretPassword!";

    public static final String WEB_DRIVER_CHROME = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_FIRE_FOX = "webdriver.gecko.driver";

    public static final String CHROME_DRIVER_EXECUTABLE = "chromedriver";
    public static final String GECKO_DRIVER_EXECUTABLE = "geckodriver";

    public static final File CHROME_DRIVER_FILE = new File(TestData.class.getClassLoader().getResource(CHROME_DRIVER_EXECUTABLE)
            .getFile());
    public static final File FF_DRIVER_FILE = new File(TestData.class.getClassLoader().getResource(GECKO_DRIVER_EXECUTABLE)
            .getFile());

}
