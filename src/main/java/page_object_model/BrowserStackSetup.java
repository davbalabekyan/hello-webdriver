package page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object_model.BrowserStackSignUpPage.BrowserStackSignUpPage;
import page_object_model.browserStackPages.BrowserStackHomePage;

import java.time.Duration;

public class BrowserStackSetup {

    private WebDriver driver;
    private BrowserStackHomePage browserStackHomePage;
    private BrowserStackSignUpPage browserStackSignUpPage;

    //    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.browserstack.com/");
    }

    //    @Test(priority = 1)
    public void navigate_to_homepage_click_on_getstarted() {
        browserStackHomePage = new BrowserStackHomePage(driver);
        browserStackHomePage.veryHeader();
        browserStackHomePage.clickOnGetStarted();
    }

    //    @Test(priority = 2)
    public void enter_userDetails() {
        browserStackSignUpPage = new BrowserStackSignUpPage(driver);
        browserStackSignUpPage.veryHeader();
        browserStackSignUpPage.enterFullName("TestUser");
        browserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
        browserStackSignUpPage.enterPassword("TestUserPassword");
    }

}
