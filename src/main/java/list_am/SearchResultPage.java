package list_am;

import configurations.core.BasePage;
import list_am.model.VAZ2107;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@id='contentr']/div[@class='dl']/a")
    private List<WebElement> searchResult;
    @FindBy(xpath = "//div[@id='contentr']/div[@class='dl']/a/div/div/div[@class='p']")
    private List<WebElement> listOfPrices;
    private List<String> listOfHeaders;
    private List<VAZ2107> listOfVAZ;
    private List<Integer> prices;

    public SearchResultPage() {
    }

    public void addHeaderToList() {
        listOfHeaders = new ArrayList<>();
        for (WebElement element : searchResult) {
            String text = element.findElement(By.xpath(".//div/div")).getText();
            listOfHeaders.add(text);
        }
    }

    public void printListOfHeaders() {
        for (String header : listOfHeaders) {
            System.out.println(header);
        }
    }

    public void addPricesToList() {
        prices = new ArrayList<>();
        for (WebElement element : listOfPrices) {
            String price = element.getText();
            price = price.replace(",", "");
            price = price.replace(" ", "");
            if (price.contains("$")) {
                price = price.replace("$", "");
                int intPrice = Integer.parseInt(price);
                int finalPrice = intPrice * 455;
                prices.add(finalPrice);
            } else if (price.contains("֏")) {
                price = price.replace("֏", "");
                int finalPrice = Integer.parseInt(price);
                prices.add(finalPrice);
            }
        }
    }

    public void printPrices() {
        for (Integer integer : prices) {
            System.out.println(integer);
        }
    }
}
