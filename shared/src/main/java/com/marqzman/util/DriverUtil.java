package com.marqzman.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
    private static final Logger logger = LogManager.getLogger();

    public static void waitThenClick(WebDriver aDriver, WebElement aWebElement) {
        waitThenClick(aDriver, aWebElement, 10);
    }

    public static void waitThenClick(WebDriver aDriver, WebElement aWebElement, int aTimeoutInSeconds) {
        DriverUtil.waitForElementEnabled(aDriver, aWebElement, aTimeoutInSeconds);
        aWebElement.click();
    }

    public static void waitForElementEnabled(WebDriver aDriver, WebElement aWebElement) {
        DriverUtil.waitForElementEnabled(aDriver, aWebElement, 10);
    }

    public static void waitForElementEnabled(WebDriver aDriver, WebElement aWebElement, int aTimeoutInSeconds) {
        new WebDriverWait(aDriver, aTimeoutInSeconds).until(ExpectedConditions.elementToBeClickable(aWebElement));
    }

    public static void sendKeys(WebElement aWebElement, String aText) {
        logger.trace("Clearing text...");
        aWebElement.clear();
        logger.trace("Entering text...");
        logger.debug("Text to enter: '{}'", aText);
        aWebElement.sendKeys(aText);
    }

}
