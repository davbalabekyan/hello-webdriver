package list_am;

import configurations.core.BasePage;
import configurations.core.Driver;
import configurations.core.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final WebDriver driver = Driver.getDriver();
    @FindBy(xpath = "//*[@id='idSearchBox']")
    private WebElement searchInput;


    private WebElement getLanguageWebElement(WebDriver driver, String language) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", language)));
    }

    public void chooseLanguage(String language) {
        WebElement english = getLanguageWebElement(driver, language);
        UiHelper.clickOnWebElement(english);
    }

    public void search(String whatSearch) {
        searchInput.sendKeys(whatSearch, Keys.ENTER);
    }

    @Override
    protected String pageUrl() {
        return "https://www.list.am/";
    }
}
