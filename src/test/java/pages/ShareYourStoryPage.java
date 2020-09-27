package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

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

    public boolean getSubmitButtonState() {
        return submitButton.isEnabled();
    }

    public static class Form {
        public void FillForm(Map<String, String> data) {
            storyTextArea.sendKeys(data.get("text"));
            yourNameField.sendKeys(data.get("name"));
            yourContactNumberField.sendKeys(data.get("number"));
            yourLocationField.sendKeys(data.get("location"));
            yourEmailField.sendKeys(data.get("email"));
        }
    }

}





