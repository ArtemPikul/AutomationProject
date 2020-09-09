package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(), \"Fire destroys Greece's largest migrant camp\")]")
    private List<WebElement> articleHeadlineList;

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private List<WebElement> secondaryArticleHeadlinesList;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getExpectedArticleHeadlineText() {
        return articleHeadlineList.get(0).getText();
    }

    public List<WebElement> getSecondaryArticleHeadlinesLIst() {
        return secondaryArticleHeadlinesList;
    }
}
