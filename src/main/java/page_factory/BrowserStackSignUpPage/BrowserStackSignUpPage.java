package page_factory.BrowserStackSignUpPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackSignUpPage {

    @FindBy(xpath = "//h1")
    private WebElement header;
    @FindBy(xpath = "//*[@id='user_full_name']")
    private WebElement userName;
    @FindBy(xpath = "//*[@id='user_email_login']")
    private WebElement businessEmail;
    @FindBy(xpath = "//*[@id='user_password']")
    private WebElement password;

    public BrowserStackSignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void veryHeader() {
        String getHeaderText = header.getText().trim();
//        Assert.assertEquals("Create a FREE Account", getHeaderText);
    }

    public void enterFullName(String arg1) {
        userName.sendKeys(arg1);
    }

    public void enterBusinessEmail(String arg1) {
        businessEmail.sendKeys(arg1);
    }

    public void enterPassword(String arg1) {
        password.sendKeys(arg1);
    }
}
