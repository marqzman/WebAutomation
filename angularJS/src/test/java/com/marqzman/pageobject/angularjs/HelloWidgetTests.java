package com.marqzman.pageobject.angularjs;

import com.marqzman.pageobject.angularjs.widget.HelloWidget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Salome Marquez (marquez.salomej@gmail.com)
 * @since 1.0.0
 */
public class HelloWidgetTests extends AngularJSPageTest {
    protected HelloWidget helloWidget;

    @BeforeEach
    public void findHelloWidget() {
        helloWidget = angularJSPage.helloWidget();
    }

    @Test
    public void shouldSeeHelloName() throws Exception {
        String name = "world";
        String output = helloWidget.typeText(name).readOutput();

        assertThat(output).isEqualTo("Hello world!");
    }
}
