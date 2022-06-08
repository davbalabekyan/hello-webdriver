import list_am.HomePage;
import list_am.SearchResultPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListAmTest extends BaseTest {

    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @BeforeClass
    public void initPages() {
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        homePage.get();
    }

    @Test
    public void searchSomethingTest() {
        homePage.chooseLanguage("English");
        homePage.search("VAZ 2107");
    }

    @Test
    public void getListOfHeaders() {
        homePage.chooseLanguage("English");
        homePage.search("VAZ 2107");
        searchResultPage.addHeaderToList();
        searchResultPage.addPricesToList();
        searchResultPage.printListOfHeaders();
        searchResultPage.printPrices();
    }
}
