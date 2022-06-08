package page_object_model.browserStackPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackHomePage {

    private final WebDriver driver;
    private final By header = By.xpath("//h1");
    private final By getStared = By.xpath("//*[@id='signupModalButton']");

    public BrowserStackHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void veryHeader() {
        String getHeaderText = driver.findElement(header).getText();
//        Assert.assertEquals("App & Browser Testing Made Easy", getHeaderText);
    }

    public void clickOnGetStarted() {
        driver.findElement(getStared).click();
    }
}
