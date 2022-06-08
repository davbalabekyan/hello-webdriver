package page_factory.browserStackPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackHomePage {

    @FindBy(xpath = "//h1")
    private WebElement header;
    @FindBy(xpath = "//*[@id='signupModalButton']")
    private WebElement getStarted;

    public BrowserStackHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void veryHeader() {
        String getHeaderText = header.getText();
//        Assert.assertEquals("App & Browser Testing Made Easy", getHeaderText);
    }

    public void clickOnGetStarted() {
        getStarted.click();
    }
}
