package wikipedia.pages;

import configurations.core.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wikipedia.WikipediaBasePage;

@SuppressWarnings(value = "all")
public class MainPage extends WikipediaBasePage {

    @FindBy(xpath = "//*[@id='pt-login']/a")
    private WebElement loginButton;

    @Override
    protected String pageUrl() {
        return "https://en.wikipedia.org";
    }

    public void openLoginPage() {
        UiHelper.clickOnWebElement(loginButton);
    }
}
