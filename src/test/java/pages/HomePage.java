package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(), 'News')]")
    private WebElement newsLink;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;

//    @FindBy(xpath = "//div[@class='sign_in-container']")
//    private WebElement signInPopUp;

    @FindBy(xpath = "//button[contains(text(), 'Maybe later')]")
    private WebElement signInPopupMaybeLater;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NewsPage clickOnHeaderNewsLink() {
        newsLink.click();
        waitForPageReadyState(WAIT_TIMEOUT);
        try {
            signInPopupMaybeLater.click();
        } finally {
            return new NewsPage(driver);
        }

    }

    public void searchByKeyword(String keyword) {
        searchField.sendKeys(keyword, Keys.ENTER);
    }

}
