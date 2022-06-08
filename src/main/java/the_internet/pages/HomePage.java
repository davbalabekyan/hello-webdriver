package the_internet.pages;

import configurations.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='content']/ul/li[2]/a")
    private WebElement addAndRemovePage;
    @FindBy(xpath = "//*[@id='content']/ul/li[3]/a")
    private WebElement basicAuthPage;
    @FindBy(xpath = "//*[@id='content']/ul/li[6]/a")
    private WebElement checkboxes;
    @FindBy(xpath = "//*[@id='content']/ul/li[7]/a")
    private WebElement contextMenu;
    @FindBy(xpath = "//*[@id='content']/ul/li[5]/a")
    private WebElement challengingDOM;

    public void openAddAndRemovePage() {
        addAndRemovePage.click();
    }

    public void openBasicAuthPage() {
        basicAuthPage.click();
    }

    public void openCheckboxesPage() {
        checkboxes.click();
    }

    public void openContextMenuPage() {
        contextMenu.click();
    }

    public void openChallengingDOMPage() {
        challengingDOM.click();
    }

    @Override
    protected String pageUrl() {
        return "https://the-internet.herokuapp.com/";
    }
}
