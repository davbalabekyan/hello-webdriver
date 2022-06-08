import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import the_internet.pages.*;

public class TheInternetTest extends BaseTest {

    private HomePage homePage;
    private AddAndRemovePage addAndRemovePage;
    private BasicAuthPage basicAuthPage;
    private CheckboxesPage checkboxesPage;
    private ContextMenuPage contextMenuPage;
    private ChallengingDOMPage challengingDOMPage;

    @BeforeClass
    public void initPages() {
        homePage = new HomePage();
        addAndRemovePage = new AddAndRemovePage();
        basicAuthPage = new BasicAuthPage();
        checkboxesPage = new CheckboxesPage();
        contextMenuPage = new ContextMenuPage();
        challengingDOMPage = new ChallengingDOMPage();
        homePage.get();
    }

    @Test
    public void addAndRemoveElements() {
        homePage.openAddAndRemovePage();
        addAndRemovePage.addElement();
        addAndRemovePage.deleteElement();
        Assert.assertEquals("", "");
    }

//    @Test
//    public void login() throws InterruptedException {
//        homePage.openBasicAuthPage();
//        basicAuthPage.login();
//        Thread.sleep(10000);
//    }

    @Test
    public void checkboxesTest() {
        homePage.openCheckboxesPage();
        checkboxesPage.clickCheckboxTwo();
        checkboxesPage.clickCheckboxTwo();
        checkboxesPage.clickCheckboxOne();
        checkboxesPage.clickCheckboxOne();
        Assert.assertEquals("", "");
    }

    @Test
    public void contextMenuTest() {
        homePage.openContextMenuPage();
        contextMenuPage.rightClickOnContext();
    }

    @Test
    public void challengingDOMTest() {
        homePage.openChallengingDOMPage();
        System.out.println(challengingDOMPage.esimInch());
    }
}
