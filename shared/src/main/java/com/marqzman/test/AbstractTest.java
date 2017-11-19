package com.marqzman.test;

import com.marqzman.util.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 *
 * Meant to be the parent class for all Test classes.
 * <p>Provides common functionality useful for setting up a Selenium test.</p>
 */
public abstract class AbstractTest {
    protected WebDriver driver;

    /**
     * Initializes the WebDriver.
     * <p>Reads the system property 'browser' and initializes that corresponding WebDriver. If a WebDriver is not supported
     * or 'browser' is undefined, the default is Chrome.</p>
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected void initializeDriver() throws IllegalAccessException, InstantiationException {
        Browser browser = Browser.fromString(System.getProperty("browser"));
        WebDriverManager.getInstance(browser.getDriverClass()).setup();
        this.driver = browser.getDriverClass().newInstance();
    }

    /**
     * Quits the WebDriver, closing all open windows.
     */
    protected void tearDownDriver() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
