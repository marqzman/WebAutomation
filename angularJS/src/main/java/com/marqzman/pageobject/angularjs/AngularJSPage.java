package com.marqzman.pageobject.angularjs;

import com.marqzman.pageobject.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 */
public class AngularJSPage extends AbstractPage {
    private static Logger logger = LogManager.getLogger();
    private static final String URL = System.getProperty("angularJS.url");

    /**
     * Navitage to the AngularJS home page with the given browser.
     * @param aDriver The driver to open the page in.
     * @return the AngularJS page object.
     */
    public static AngularJSPage navigateWith(WebDriver aDriver) {
        logger.debug("Navigating to '{}'", AngularJSPage.URL);
        logger.debug("Browser '{}'", System.getProperty("browser"));
        aDriver.get(AngularJSPage.URL);
        return new AngularJSPage(aDriver);
    }

    public AngularJSPage(WebDriver aWebDriver) {
        super(aWebDriver);
    }
}
