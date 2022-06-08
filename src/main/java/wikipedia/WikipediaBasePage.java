package wikipedia;

import configurations.core.BasePage;
import configurations.core.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class WikipediaBasePage extends BasePage {

    @FindBy(xpath = "//*[@id='n-mainpage-description']/a")
    private WebElement mainPageHref;

    public void goToMainPage() {
        UiHelper.clickOnWebElement(mainPageHref);
    }
}
