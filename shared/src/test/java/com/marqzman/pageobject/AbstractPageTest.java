package com.marqzman.pageobject;

import com.marqzman.test.AbstractTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractPageTest extends AbstractTest {

    @BeforeEach
    public void setup() throws InstantiationException, IllegalAccessException {
        super.initializeDriver();
    }

    @AfterEach
    public void tearDown() {
        super.tearDownDriver();
    }

    @Test
    void getTitle() {
        String expectedTitle = "Google";
        driver.get("https://www.google.com");
        String actualTitle = (new AbstractPageImpl(driver)).getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    class AbstractPageImpl extends AbstractPage {

        public AbstractPageImpl(WebDriver aWebDriver) {
            super(aWebDriver);
        }
    }

}