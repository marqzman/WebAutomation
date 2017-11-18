package com.marqzman.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Supported browser types.
 *
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 */
public enum Browser {
    CHROME (ChromeDriver.class),
    FIREFOX (FirefoxDriver.class),
    IE (InternetExplorerDriver.class),
    EDGE (EdgeDriver.class),
    NONSUPPORTED (ChromeDriver.class);

    private Class<? extends WebDriver> driverClass;

    Browser(Class<? extends WebDriver> aDriverClass) {
        this.driverClass = aDriverClass;
    }

    public Class<? extends WebDriver> getDriverClass() {
        return this.driverClass;
    }

    /**
     * Select a browser by name (not case sensitive).
     * Available options: chrome, firefox, ff, internetexplorer, ie, edge, phantomjs.
     *
     * @param text
     * @return
     */
    public static Browser fromString(String text) {
        Browser theBrowser;

        switch (text.toUpperCase()) {
            case "CHROME":
                theBrowser = CHROME;
                break;
            case "FIREFOX":
            case "FF":
                theBrowser = FIREFOX;
                break;
            case "IE":
            case "INTERNETEXPLORER":
            case "INTERNET EXPLORER":
                theBrowser = IE;
                break;
            case "EDGE":
                theBrowser = EDGE;
                break;
            default:
                theBrowser = NONSUPPORTED;
                break;
        }

        return theBrowser;
    }
}
