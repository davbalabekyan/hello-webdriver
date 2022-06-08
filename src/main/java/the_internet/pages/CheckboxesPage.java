package the_internet.pages;

import configurations.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage {

    @FindBy(xpath = "//*[@id='checkboxes']/input[1] ")
    private WebElement checkboxOne;
    @FindBy(xpath = "//*[@id='checkboxes']/input[2] ")
    private WebElement checkboxTwo;

    public void clickCheckboxOne() {
        checkboxOne.click();
    }

    public void clickCheckboxTwo() {
        checkboxTwo.click();
    }
}
