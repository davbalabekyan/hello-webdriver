package the_internet.pages;

import configurations.core.BasePage;
import configurations.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy(xpath = "//*[@id='hot-spot']")
    private WebElement context;

    public void rightClickOnContext() {
        WebDriver driver = Driver.getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(context)
                .contextClick()
                .build()
                .perform();
        driver.switchTo().alert().accept();
    }
}
