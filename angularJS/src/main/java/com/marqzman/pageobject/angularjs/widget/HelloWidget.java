package com.marqzman.pageobject.angularjs.widget;

import com.marqzman.util.DriverUtil;
import com.marqzman.widget.AbstractWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 *
 * Represents the Hello Widget found in angularjs.org
 *
 * <img src="images/AngularJS_HelloWidget.PNG"/>
 */
public class HelloWidget extends AbstractWidget {
    private static final Logger logger = LogManager.getLogger();

    private By labelFieldby = By.cssSelector("div > label");
    private WebElement labelField;

    @FindBy(css = "input[ng-model='yourName']")
    private WebElement inputField;

    private By outputFieldBy = By.cssSelector("div > h1.ng-binding");
    private WebElement outputField;

    public HelloWidget(WebDriver aWebDriver, WebElement aRootElement) {
        super(aWebDriver, aRootElement);

        this.labelField = getRootElement().findElement(this.labelFieldby);
        this.outputField = getRootElement().findElement(this.outputFieldBy);
    }

    /**
     * Enters the given text in the Hello widget input field.
     * @param aString the String to type.
     * @return this page object.
     */
    public HelloWidget typeText(String aString) {
        logger.trace("Typing text into the input field...");
        DriverUtil.sendKeys(this.inputField, aString);
        return this;
    }

    /**
     * Returns the string outputted by the widget.
     * @return the ouput of the widget.
     */
    public String readOutput() {
        String output = this.outputField.getText();
        logger.debug("Hello widget output: {}", output);
        return output;
    }
}
