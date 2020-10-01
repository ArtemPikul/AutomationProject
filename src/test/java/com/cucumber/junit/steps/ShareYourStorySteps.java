package com.cucumber.junit.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cucumber.junit.pages.PageProvider.shareYourStoryPage;
import static org.assertj.core.api.Assertions.assertThat;

public class ShareYourStorySteps {



    @When("the user enters the {string} in the story text form")
    public void fillStoryTextForm(String text) {
        shareYourStoryPage.fillStoryTextForm(text);
    }

    @When("the user enters the {string} in the name field")
    public void fillYourNameField(String name) {
        shareYourStoryPage.fillYourNameField(name);
    }

    @When("the user enters the {string} in email field")
    public void fillYourEmailField(String email) {
        shareYourStoryPage.fillYourEmailField(email);
    }

    @When("the user enters the {string} in contact number field")
    public void fillYourNumberField(String number) {
        shareYourStoryPage.fillYourNumberField(number);
    }

    @When("the user enters the {string} in location field")
    public void fillYourLocationField(String location) {
        shareYourStoryPage.fillYourLocationField(location);
    }

    @When("the user accepts terms of service")
    public void acceptTermsOfService() {
        shareYourStoryPage.acceptTermsOfService();
    }

    @When("the user confirms that he is over sixteen years old")
    public void acceptOverSixteenYearsOldCondition() {
        shareYourStoryPage.acceptOverSixteenYearsOldCondition();
    }

    @When("the user clicks on \"Submit\" button")
    public void clickSubmitButton() {
        shareYourStoryPage.clickSubmitButton();
    }

    @Then("page with the link {string} remains displayed")
    public void verifyPageURL(String expectedPageURL) {
        assertThat(shareYourStoryPage.isPageWithURLDisplayed(expectedPageURL))
                .overridingErrorMessage("Page with URL %s is not displayed", expectedPageURL)
                .isTrue();
    }

    @Then("the \"Submit\" button remains active")
    public void verifySubmitButtonState() {
        assertThat(shareYourStoryPage.getSubmitButtonState())
                .isTrue();
    }

}
