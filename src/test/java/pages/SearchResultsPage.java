package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//p/a/span")
    private List<WebElement> searchResultArticleNames;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstSearchResult() {
        return searchResultArticleNames.get(0).getText();
    }

}
