package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class ShareYourStoryPage extends BasePage {


    @FindBy(xpath = "//textarea")
    private static WebElement storyTextArea;

    @FindBy(xpath = "//input[@aria-label='Name']")
    private static WebElement yourNameField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private static WebElement yourEmailField;

    @FindBy(xpath = "//input[@aria-label='Contact number ']")
    private static WebElement yourContactNumberField;

    @FindBy(xpath = "//input[@aria-label='Location ']")
    private static WebElement yourLocationField;

    @FindBy(xpath = "//p[contains(text(), 'I am over 16 years old')]")
    private WebElement overSixteenYearsCheckbox;

    @FindBy(xpath = "//p[contains(text(), 'I accept the ')]")
    private WebElement acceptTermsCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private WebElement submitButton;

    public ShareYourStoryPage(WebDriver driver) {
        super(driver);
    }

    public ShareYourStoryPage fillInStoryTextArea(String story) {
        waitForElementVisibility(WAIT_TIMEOUT, storyTextArea);
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

    public ShareYourStoryPage acceptOverSixteenYearsOldCondition() {
        overSixteenYearsCheckbox.click();
        return this;
    }

    public ShareYourStoryPage acceptTermsOfService() {
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

    public boolean getSubmitButtonState() {
        return submitButton.isEnabled();
    }

    public static class Form {
        public void FillForm(HashMap<String, String> values) {
            storyTextArea.sendKeys(values.get("text"));
            yourNameField.sendKeys(values.get("name"));
            yourContactNumberField.sendKeys(values.get("number"));
            yourLocationField.sendKeys(values.get("location"));
            yourEmailField.sendKeys(values.get("email"));
        }
    }

}





