package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTwoTests extends BaseTest {

    private static final String STORY_TEXT = "test story text";
    private static final String NAME = "Name";
    private static final String CONTACT_NUMBER = "+380112223344";
    private static final String LOCATION = "Kyiv";

    private static final String PAGE_URL_FOR_ASSERT = "https://www.bbc.com/news/10725415";

    @Test
    public void checkThatUserCannotSubmitQuestionIfOneOfTheFieldsHasInvalidData() {
        String currentURL = homePage.clickOnHeaderNewsLink()
                .clickOnCoronavirusTabLink()
                .clickOnYourCoronavirusStoriesLink()
                .clickOnShareWithBBCLink()
                .fillInStoryTextArea(STORY_TEXT)
                .fillInNameField(NAME)
                .fillInEmailField("invalid email")
                .fillInContactNumberField(CONTACT_NUMBER)
                .fillInLocationField(LOCATION)
                .acceptOverSixteenYearsOldCondition()
                .acceptTermsOfService()
                .clickSubmitButton()
                .getCurrentPageURL();

        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(shareYourStoryPage.getSubmitButtonState());
    }

    @Test
    public void checkThatUserCannotSubmitQuestionIfUnderSixteenIsNotChecked() {
        String currentURL = homePage.clickOnHeaderNewsLink()
                .clickOnCoronavirusTabLink()
                .clickOnYourCoronavirusStoriesLink()
                .clickOnShareWithBBCLink()
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
                .clickOnCoronavirusTabLink()
                .clickOnYourCoronavirusStoriesLink()
                .clickOnShareWithBBCLink()
                .fillInStoryTextArea(STORY_TEXT)
                .fillInNameField(NAME)
                .fillInEmailField("pikul.a@outlook.com")
                .fillInContactNumberField(CONTACT_NUMBER)
                .fillInLocationField(LOCATION)
                .acceptOverSixteenYearsOldCondition()
                .clickSubmitButton()
                .getCurrentPageURL();

        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(shareYourStoryPage.getSubmitButtonState());
    }
}
