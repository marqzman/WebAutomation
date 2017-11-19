package com.marqzman.widget;

import com.marqzman.pageobject.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 */
public abstract class AbstractWidget extends AbstractPage {
    private WebElement rootElement;

    public AbstractWidget(WebDriver aDriver, WebElement aRootElement) {
        super(aDriver);
        this.rootElement = aRootElement;
    }

    public WebElement getRootElement() {
        return rootElement;
    }
}
