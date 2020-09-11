package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShareYourStoryPage extends BasePage {

    @FindBy(xpath = "//textarea")
    private WebElement storyTextArea;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement yourNameField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement yourEmailField;

    @FindBy(xpath = "//input[@aria-label='Contact number ']")
    private WebElement yourContactNumberField;

    @FindBy(xpath = "//input[@aria-label='Location ']")
    private WebElement yourLocationField;

    @FindBy(xpath = "//p[contains(text(), 'I am over 16 years old')]")
    private WebElement over16YearsCheckbox;

    @FindBy(xpath = "//p[contains(text(), 'I accept the ')]")
    private WebElement acceptTermsCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private WebElement submitButton;

    public ShareYourStoryPage(WebDriver driver) {
        super(driver);
    }

    public ShareYourStoryPage fillInStoryTextArea(String story) {
        storyTextArea.sendKeys(story);
        return this;
    }

    public ShareYourStoryPage fillInNameField(String name) {
        yourNameField.sendKeys(name);
        return this;
    }

    public ShareYourStoryPage fillInEmailField(String email) {
        yourEmailField.sendKeys(email);
        return this;
    }

    public ShareYourStoryPage fillInContactNumberField(String number) {
        yourContactNumberField.sendKeys(number);
        return this;
    }

    public ShareYourStoryPage fillInLocationField(String location) {
        yourLocationField.sendKeys(location);
        return this;
    }

    public ShareYourStoryPage acceptNecessaryConditions() {
        over16YearsCheckbox.click();
        acceptTermsCheckbox.click();
        return this;
    }

    public ShareYourStoryPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public ShareYourStoryPage waitForPageReadyState(long timeout) {
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }


}
