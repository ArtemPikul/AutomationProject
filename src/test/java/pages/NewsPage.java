package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(), \"Fire destroys Greece's largest migrant camp\")]")
    private List<WebElement> articleHeadlineList;

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private List<WebElement> secondaryArticleHeadlinesList;

    @FindBy(xpath = "//a[@aria-label='From Europe']")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")
    private List<WebElement> coronavirusTabLink;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadlineArticleCategoryText() {
        return categoryList.get(0).getText();
    }

    public CoronavirusPage clickOnCoronavirusTabLink() {
        coronavirusTabLink.get(0).click();
        waitForPageReadyState(WAIT_TIMEOUT);
        return new CoronavirusPage(driver);
    }


    public WebElement getCoronavirusTabLink() {
        return coronavirusTabLink.get(0);
    }

    public String getExpectedArticleHeadlineText() {
        return articleHeadlineList.get(0).getText();
    }

    public List<WebElement> getSecondaryArticleHeadlinesLIst() {
        return secondaryArticleHeadlinesList;
    }

    public NewsPage waitForPageReadyState(long timeout) {
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public NewsPage waitForElementVisibility(long timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }
}
