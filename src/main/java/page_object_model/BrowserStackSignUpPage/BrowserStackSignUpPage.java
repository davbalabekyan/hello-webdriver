package page_object_model.BrowserStackSignUpPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackSignUpPage {

    private final WebDriver driver;
    private final By header = By.xpath("//h1");
    private final By userName = By.xpath("//*[@id='user_full_name']");
    private final By businessEmail = By.xpath("//*[@id='user_email_login']");
    private final By password = By.xpath("//*[@id='user_password']");

    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void veryHeader() {
        String getHeaderText = driver.findElement(header).getText().trim();
//        Assert.assertEquals("Create a FREE Account", getHeaderText);
    }

    public void enterFullName(String arg1) {
        driver.findElement(userName).sendKeys(arg1);
    }

    public void enterBusinessEmail(String arg1) {
        driver.findElement(businessEmail).sendKeys(arg1);
    }

    public void enterPassword(String arg1) {
        driver.findElement(password).sendKeys(arg1);
    }
}
