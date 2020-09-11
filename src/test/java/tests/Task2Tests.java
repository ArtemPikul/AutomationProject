package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Tests extends BaseTest {

    private static final String STORY_TEXT = "test story text";
    private static final String NAME = "Name";
    private static final String EMAIL = "invalid email";
    private static final String CONTACT_NUMBER = "+380112223344";
    private static final String LOCATION = "Kyiv";

    private static final String PAGE_URL_FOR_ASSERT = "https://www.bbc.com/news/10725415";

    @Test(invocationCount = 10)
    public void checkThatUserCannotSubmitQuestionIfOneOfTheFieldsHasInvalidData() {
        String currentURL = homePage.clickOnHeaderNewsLink()
                .waitForPageReadyState(15)
                .waitForElementVisibility(15, newsPage.getSignInPopUp())
                .clickOnMaybeLaterOptionInSignInPopup()
                .clickOnCoronavirusTabLink()
                .waitForPageReadyState(15)
                .clickOnYourCoronavirusStoriesLink()
                .waitForPageReadyState(15)
                .clickOnShareWithBBCLink()
                .waitForPageReadyState(15)
                .fillInStoryTextArea(STORY_TEXT)
                .fillInNameField(NAME)
                .fillInEmailField(EMAIL)
                .fillInContactNumberField(CONTACT_NUMBER)
                .fillInLocationField(LOCATION)
                .acceptOver16YearsOldCondition()
                .acceptTermsOfService()
                .clickSubmitButton()
                .getCurrentPageURL();
        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(shareYourStoryPage.getSubmitButtonState());
    }

    @Test
    public void checkThatUserCannotSubmitQuestionIfUnder16IsNotChecked() {
        String currentURL = homePage.clickOnHeaderNewsLink()
                .waitForPageReadyState(15)
                .waitForElementVisibility(15, newsPage.getSignInPopUp())
                .clickOnMaybeLaterOptionInSignInPopup()
                .clickOnCoronavirusTabLink()
                .waitForPageReadyState(15)
                .clickOnYourCoronavirusStoriesLink()
                .waitForPageReadyState(15)
                .clickOnShareWithBBCLink()
                .waitForPageReadyState(15)
                .fillInStoryTextArea(STORY_TEXT)
                .fillInNameField(NAME)
                .fillInEmailField("pikul.a@outlook.com")
                .fillInContactNumberField(CONTACT_NUMBER)
                .fillInLocationField(LOCATION)
                .acceptTermsOfService()
                .clickSubmitButton()
                .getCurrentPageURL();
        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(shareYourStoryPage.getSubmitButtonState());
    }

    @Test
    public void checkThatUserCannotSubmitQuestionIfTermsOfServiceIsNotChecked() {
        String currentURL = homePage.clickOnHeaderNewsLink()
                .waitForPageReadyState(15)
                .waitForElementVisibility(15, newsPage.getSignInPopUp())
                .clickOnMaybeLaterOptionInSignInPopup()
                .clickOnCoronavirusTabLink()
                .waitForPageReadyState(15)
                .clickOnYourCoronavirusStoriesLink()
                .waitForPageReadyState(15)
                .clickOnShareWithBBCLink()
                .waitForPageReadyState(15)
                .fillInStoryTextArea(STORY_TEXT)
                .fillInNameField(NAME)
                .fillInEmailField("pikul.a@outlook.com")
                .fillInContactNumberField(CONTACT_NUMBER)
                .fillInLocationField(LOCATION)
                .acceptOver16YearsOldCondition()
                .clickSubmitButton()
                .getCurrentPageURL();
        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(shareYourStoryPage.getSubmitButtonState());
    }
}
