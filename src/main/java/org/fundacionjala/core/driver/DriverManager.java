package org.fundacionjala.core.driver;

import org.fundacionjala.core.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class DriverManager {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static final int TIME_OUT_IN_SECONDS = 15;
    private static DriverManager ourInstance;

    public static DriverManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DriverManager();
        }
        return ourInstance;
    }

    private DriverManager() {
        String browser = Environment.getInstance().getValue("$['local']['browser']").toUpperCase();
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
        webDriver.get("https://trello.com/login");
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public WebDriverWait getWait() {
        return webDriverWait;
    }

}