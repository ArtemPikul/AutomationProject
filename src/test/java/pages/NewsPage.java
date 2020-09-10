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

    @FindBy(xpath = "//a[@aria-label='From Europe']")
    private List<WebElement> categoryList;

    @FindBy(xpath="//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")
    private List<WebElement> coronavirusTabLink;

    @FindBy(xpath = "//div[@class='sign_in-container']")
    private WebElement signInPopUp;

    @FindBy(xpath = "//button[contains(text(), 'Maybe later')]")
    private WebElement signInPopupMaybeLater;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadlineArticleCategoryText() {
        return categoryList.get(0).getText();
    }

    public void clickOnCoronavirusTabLink() {
        coronavirusTabLink.get(0).click();
    }

    public NewsPage clickOnMaybeLaterOptionInSignInPopup() {
        signInPopupMaybeLater.click();
        return this;
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

    public WebElement getSignInPopUp() {
        return signInPopUp;
    }
}
