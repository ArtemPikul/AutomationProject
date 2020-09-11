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

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public NewsPage clickOnHeaderNewsLink() {
        newsLink.click();
        return new NewsPage(driver);
    }

    public void searchByKeyword(String keyword) {
        searchField.sendKeys(keyword, Keys.ENTER);
    }

    public WebElement getNewsLink() {
        return newsLink;
    }

}
