package instagram.pages;

import configurations.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*[@class='cmbtv']/button")
    private WebElement caches;
    @FindBy(xpath = "//div[@class='mt3GC']/button[2]")
    private WebElement notifications;
    @FindBy(xpath = "//div[@class='XrOey']/a[@class='xWeGp']")
    private WebElement directs;

    public void openDirects() {
        directs.click();
    }

    public void disableNotificationsAndCaches() {
        caches.click();
        notifications.click();
    }
}
