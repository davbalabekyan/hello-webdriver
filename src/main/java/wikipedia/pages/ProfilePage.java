package wikipedia.pages;

import configurations.core.UiHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wikipedia.WikipediaBasePage;

@SuppressWarnings(value = "all")
public class ProfilePage extends WikipediaBasePage {

    @FindBy(xpath = "//*[@id='pt-logout']/a")
    private WebElement logoutButton;
    @FindBy(xpath = "//*[@id='searchInput']")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id='pt-userpage']/a/span")
    private WebElement username;

    public String getUsername() {
        return username.getText();
    }

    public void searchArticle() {
        searchField.sendKeys(System.getProperty("article"), Keys.ENTER);
    }

    public void logOut() {
        UiHelper.clickOnWebElement(logoutButton);
    }
}
