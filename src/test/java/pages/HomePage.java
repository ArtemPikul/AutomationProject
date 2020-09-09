package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(), 'News')]")
    private WebElement newsLink;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnHeaderNewsLink() {
        newsLink.click();
    }

}
