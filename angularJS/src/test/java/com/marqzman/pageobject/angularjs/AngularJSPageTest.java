package com.marqzman.pageobject.angularjs;

import com.marqzman.test.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 */
class AngularJSPageTest extends AbstractTest {
    private AngularJSPage angularJSPage;

    @BeforeEach
    protected void setUp() throws InstantiationException, IllegalAccessException {
        super.initializeDriver();
        this.angularJSPage = AngularJSPage.navigateWith(super.driver);
    }

    @AfterEach
    protected void tearDown() {
        super.tearDownDriver();
    }

    @Test
    public void testPageTitle() throws Exception {
        String actualTitle = angularJSPage.getTitle();
        assertAll("AngularJS smoke test",
                () -> assertThat(actualTitle).contains("AngularJS"),
                () -> assertThat(actualTitle).contains("Superheroic JavaScript MVW Framework")
        );
    }
}