package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoronavirusPage extends BasePage {

    @FindBy(xpath = "//a[@class='nw-o-link']/span[contains(text(), 'Your Coronavirus Stories')]")
    private List<WebElement> yourCoronavirusStoriesLink;

    @FindBy(xpath = "//a[@href='/news/10725415']")
    private WebElement shareWithBBCLink;

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    public CoronavirusPage clickOnYourCoronavirusStoriesLink() {
        yourCoronavirusStoriesLink.get(0).click();
        waitForPageReadyState(WAIT_TIMEOUT);
        return this;
    }

    public ShareYourStoryPage clickOnShareWithBBCLink() {
        shareWithBBCLink.click();
        waitForPageReadyState(WAIT_TIMEOUT);
        return new ShareYourStoryPage(driver);
    }


}
