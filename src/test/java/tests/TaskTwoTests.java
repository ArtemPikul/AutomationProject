package tests;

import BLL.LogicLayer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShareYourStoryPage;

import java.util.HashMap;

public class TaskTwoTests extends BaseTest {

    private static final String STORY_TEXT = "test story text";
    private static final String NAME = "Name";
    private static final String CONTACT_NUMBER = "+380112223344";
    private static final String LOCATION = "Kyiv";

    private static final String PAGE_URL_FOR_ASSERT = "https://www.bbc.com/news/10725415";


    @Test
    public void checkThatUserCannotSubmitQuestionIfOneOfTheFieldsHasInvalidData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("text", STORY_TEXT);
        map.put("name", NAME);
        map.put("number", CONTACT_NUMBER);
        map.put("location", LOCATION);
        map.put("email", "invalid email");

        LogicLayer.navigateToShareYourStoryPage();
        LogicLayer.fillShareYourStoryForm(map);
        LogicLayer.acceptOverSixteenYearsOld();
        LogicLayer.acceptTermsOfService();
        String currentURL = LogicLayer.clickSubmitAndGetURL();

        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(LogicLayer.getSubmitButtonState());
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
