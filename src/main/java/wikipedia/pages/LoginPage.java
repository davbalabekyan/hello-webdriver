package wikipedia.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wikipedia.WikipediaBasePage;

@SuppressWarnings(value = "all")
public class LoginPage extends WikipediaBasePage {

    @FindBy(xpath = "//*[@id='wpName1']")
    private WebElement userNameInput;
    @FindBy(xpath = "//*[@id='wpPassword1']")
    private WebElement passwordInput;

    public void login() {
        userNameInput.sendKeys(System.getProperty("username"));
        passwordInput.sendKeys(System.getProperty("password"), Keys.ENTER);
    }
}
