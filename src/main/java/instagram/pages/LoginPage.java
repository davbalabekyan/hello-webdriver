package instagram.pages;

import configurations.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    public void login() {
        loginInput.sendKeys(System.getProperty("email"));
        passwordInput.sendKeys(System.getProperty("password"), Keys.ENTER);
    }

    @Override
    protected String pageUrl() {
        return "https://instagram.com";
    }
}
