package configurations.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private final WebDriver driver;

    public BasePage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected String pageUrl() {
        return "";
    }

    public void get() {
        driver.get(pageUrl());
    }
}
