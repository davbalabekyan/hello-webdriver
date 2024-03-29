package configurations.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UiHelper {

    private static final WebDriver driver = DriverProvider.getDriver();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;

    private UiHelper() {
    }

    public static void clickOnWebElement(final WebElement target) {
        scrollToMiddle(target);
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        target.click();
    }

    private static void scrollToMiddle(final WebElement target) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'})", target);
    }
}
