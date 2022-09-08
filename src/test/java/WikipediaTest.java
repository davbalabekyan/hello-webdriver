import configurations.core.DriverProvider;
import configurations.properties.WikipediaPropertiesConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wikipedia.pages.*;

public class WikipediaTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private SearchPage searchPage;
    private ArticlePage articlePage;

    @BeforeClass
    public void initPages() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        searchPage = new SearchPage();
        articlePage = new ArticlePage();
        WikipediaPropertiesConfiguration.configureProperties();
        mainPage.get();
    }

    @Test
    public void loginAndLogoutTest() {
        mainPage.openLoginPage();
        loginPage.login();
        profilePage.logOut();
        Assert.assertEquals(profilePage.getUsername(), System.getProperty("username"));
    }

    @Test
    public void searchArticleTest() {
        mainPage.openLoginPage();
        loginPage.login();
        profilePage.searchArticle();
        searchPage.openFirstArticle();
        profilePage.logOut();
        Assert.assertEquals(articlePage.getArticleHeading(), System.getProperty("article"));
    }

    @Test
    public void changeLanguageTest() {
        mainPage.openLoginPage();
        loginPage.login();
        profilePage.searchArticle();
        searchPage.openFirstArticle();
        articlePage.changeLanguage();
        Assert.assertEquals("", "");
    }

    @Test
    public void goToMainPageTest() {
        mainPage.openLoginPage();
        loginPage.login();
        profilePage.searchArticle();
        profilePage.goToMainPage();
        Assert.assertEquals("https://en.wikipedia.org/wiki/Main_Page", DriverProvider.getDriver().getCurrentUrl());
    }

    @Test
    public void addAllResultToDB(){
        mainPage.openLoginPage();
        loginPage.login();
        profilePage.searchArticle();
        searchPage.goToAllResultPage();
        searchPage.addResultsToDB();
        Assert.assertEquals(searchPage.getNumberOfDBItems(),searchPage.getNumberOfResult());
    }
}
