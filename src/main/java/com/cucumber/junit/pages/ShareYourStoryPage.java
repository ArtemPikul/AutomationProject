package com.cucumber.junit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    private WebElement overSixteenYearsCheckbox;

    @FindBy(xpath = "//p[contains(text(), 'I accept the ')]")
    private WebElement acceptTermsCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private WebElement submitButton;

    public void fillStoryTextForm(String text) {
        waitForPageReadyState(WAIT_TIMEOUT);
        storyTextArea.sendKeys(text);
    }

    public void fillYourNameField(String name) {
        yourNameField.sendKeys(name);
    }

    public void fillYourEmailField(String email) {
        yourEmailField.sendKeys(email);
    }

    public void fillYourNumberField(String number) {
        yourContactNumberField.sendKeys(number);
    }

    public void fillYourLocationField(String location) {
        yourLocationField.sendKeys(location);
    }

    public void acceptOverSixteenYearsOldCondition() {
        overSixteenYearsCheckbox.click();
    }

    public void acceptTermsOfService() {
        acceptTermsCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean getSubmitButtonState() {
        return submitButton.isEnabled();
    }

}





