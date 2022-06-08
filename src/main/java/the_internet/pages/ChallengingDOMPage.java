package the_internet.pages;

import configurations.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChallengingDOMPage extends BasePage {

    @FindBy(tagName = "script")
    private List<WebElement> scripts;

    public String esimInch() {
        String answer = "";
        for (WebElement script : scripts) {
            String focusText = script.getAttribute("innerHTML");
            if (focusText.contains("canvas.strokeText")) {
                answer = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
                return answer;
            }
        }
        return answer;
    }

}
