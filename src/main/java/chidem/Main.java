package chidem;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://list.am");

//        WebElement targetElement = driver.findElement(By.xpath("//a[@href='/am/']"));
//        WebElement targetElement = driver.findElement(By.xpath("//*[text()='Հայերեն']"));
        WebElement targetElement = getLanguageWebElement(driver, "Հայերեն");
        targetElement.click();

        WebElement searchField = driver.findElement(By.id("idSearchBox"));
        searchField.sendKeys("հյուրանոց գյումրի", Keys.ENTER);

        List<WebElement> titles = driver.findElements(By.xpath("//div[@id='contentr']//a//div/div[1][not(@class='p')]"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@id='contentr']//a//div/div[1][@class='p']"));

        System.out.println(getNameByPrice(driver, "18,000 ֏"));
        List<Integer> priceNumbers = new ArrayList<>();
        for (WebElement x : prices) {
            String xPrice = x.getText();
            xPrice = xPrice.replace(",", "");
            xPrice = xPrice.replace(" ", "");
            if (xPrice.contains("$")) {
                xPrice = xPrice.replace("$", "");
                int intPrice = Integer.parseInt(xPrice);
                int finalPrice = intPrice * 460;
                priceNumbers.add(finalPrice);
            }
            if (xPrice.contains("֏")) {
                xPrice = xPrice.replace("֏", "");
                int intPrice = Integer.parseInt(xPrice);
                priceNumbers.add(intPrice);
            }
        }
    }

    private static WebElement getLanguageWebElement(WebDriver driver, String language) {
//        return driver.findElement(By.xpath("//*[text()='" + language + "']"));
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", language)));
    }

    private static String getNameByPrice(final WebDriver driver, final String price) {
        return driver.findElement(By.xpath(String.format("//div[text()='%s']//ancestor::a/div/div[1]", price))).getText();
    }
}
