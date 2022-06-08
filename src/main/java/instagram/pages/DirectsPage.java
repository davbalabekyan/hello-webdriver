package instagram.pages;

import configurations.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectsPage extends BasePage {

    @FindBy(xpath = "//*[@id='react-root']/section/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div[1]/a/div")
    private WebElement firstDirect;
    @FindBy(xpath = "//div/textarea")
    private WebElement messageInput;
    @FindBy(xpath = "//*[@id='react-root']/section/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[17]/div[2]/div/div/div/div/div/div/div/div/div")
    private WebElement lastMessage;

    public void openFirstDirect() {
        firstDirect.click();
    }

    public void writeMessage() {
        messageInput.sendKeys(System.getProperty("message"), Keys.ENTER);
    }

    public String getLastMessage() {
        return lastMessage.getText();
    }
}
