package com.marqzman.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private static Logger logger = LogManager.getLogger();
    private WebDriver driver;

    public AbstractPage(WebDriver aWebDriver) {
        this.driver = aWebDriver;

        PageFactory.initElements(this.getDriver(), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTitle() {
        logger.trace("Reading the page's title...");
        String title = this.getDriver().getTitle();
        logger.debug("Title is '{}'", title);
        return title;
    }
}
