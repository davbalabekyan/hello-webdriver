package wikipedia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wikipedia.WikipediaBasePage;

@SuppressWarnings(value = "all")
public class ArticlePage extends WikipediaBasePage {

    @FindBy(xpath = "//*[@id='firstHeading']")
    private WebElement articleHeading;
    @FindBy(xpath = "//*[@id='p-lang']/div/ul/li[113]/a")
    private WebElement russianLanguage;

    public String getArticleHeading() {
        return articleHeading.getText();
    }

    public void changeLanguage() {
        russianLanguage.click();
    }
}
