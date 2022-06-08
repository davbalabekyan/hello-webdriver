package the_internet.pages;

import configurations.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAndRemovePage extends BasePage {

    @FindBy(xpath = "//*[@id='content']/div/button")
    private WebElement addElement;
    @FindBy(xpath = "//*[@id='elements']/button[1]")
    private WebElement deleteElement;

    public void addElement() {
        addElement.click();
    }

    public void deleteElement() {
        deleteElement.click();
    }
}
