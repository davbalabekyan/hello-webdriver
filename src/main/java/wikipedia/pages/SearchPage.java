package wikipedia.pages;

import configurations.core.UiHelper;
import configurations.jdbc.manager.ArticleManager;
import configurations.jdbc.model.Article;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wikipedia.WikipediaBasePage;

import java.util.List;

@SuppressWarnings(value = "all")
public class SearchPage extends WikipediaBasePage {

    @FindBy(xpath = " //*[@id='mw-content-text']/div[3]/ul/li[1]/div[1]/a")
    private WebElement firstArticle;
    @FindBy(xpath = "//p[@class='mw-search-pager-bottom']/a[last()]")
    private WebElement lastPageOfSearch;
    @FindBy(xpath = "//ul[@class='mw-search-results']/li/div/a")
    private List<WebElement> searchResult;
    private ArticleManager manager;

    public int getNumberOfResult() {
        return searchResult.size();
    }

    public int getNumberOfDBItems() {
        List<Article> allArticles = manager.getAll();
        return allArticles.size();
    }

    public void openFirstArticle() {
        UiHelper.clickOnWebElement(firstArticle);
    }

    public void goToAllResultPage() {
        UiHelper.clickOnWebElement(lastPageOfSearch);
    }

    public void addResultsToDB() {
        manager = new ArticleManager();
        for (WebElement element : searchResult) {
            Article article = new Article();
            article.setName(element.getAttribute("title"));
            article.setHref(element.getAttribute("href"));
            manager.create(article);
        }
    }
}
