package com.marqzman;

import com.marqzman.util.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() throws IllegalAccessException, InstantiationException {
        Browser browser = Browser.fromString(System.getProperty("browser"));
        WebDriverManager.getInstance(browser.getDriverClass()).setup();
        this.driver = browser.getDriverClass().newInstance();
    }

    @AfterEach
    void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
