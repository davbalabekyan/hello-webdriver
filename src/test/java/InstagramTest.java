import configurations.properties.InstagramPropertiesConfiguration;
import instagram.pages.DirectsPage;
import instagram.pages.LoginPage;
import instagram.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InstagramTest extends BaseTest {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private DirectsPage directsPage;

    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        directsPage = new DirectsPage();
        InstagramPropertiesConfiguration.configureProperties();
        loginPage.get();
    }

    @Test
    public void writeMessageTest() {
        loginPage.login();
        profilePage.disableNotificationsAndCaches();
        profilePage.openDirects();
        directsPage.openFirstDirect();
        directsPage.writeMessage();
        Assert.assertEquals(directsPage.getLastMessage(), System.getProperty("message"));
    }
}
