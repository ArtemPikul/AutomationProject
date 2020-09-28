package tests;

import logiclayer.LogicLayer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TaskTwoTests extends BaseTest {

    private static final String STORY_TEXT = "test story text";
    private static final String NAME = "Name";
    private static final String CONTACT_NUMBER = "+380112223344";
    private static final String LOCATION = "Kyiv";

    private static final String PAGE_URL_FOR_ASSERT = "https://www.bbc.com/news/10725415";


    @Test
    public void checkThatUserCannotSubmitQuestionIfOneOfTheFieldsHasInvalidData() {
        Map<String, String> data = new HashMap<>();
        data.put("text", STORY_TEXT);
        data.put("name", NAME);
        data.put("number", CONTACT_NUMBER);
        data.put("location", LOCATION);
        data.put("email", "invalid email");

        LogicLayer logicLayer = new LogicLayer();

        String currentURL = logicLayer.navigateToShareYourStoryPage()
                .fillShareYourStoryForm(data)
                .acceptOverSixteenYearsOld()
                .acceptTermsOfService()
                .clickSubmitAndGetURL();

        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(logicLayer.getSubmitButtonState());
    }

    @Test
    public void checkThatUserCannotSubmitQuestionIfUnderSixteenIsNotChecked() {
        Map<String, String> data = new HashMap<>();
        data.put("text", STORY_TEXT);
        data.put("name", NAME);
        data.put("number", CONTACT_NUMBER);
        data.put("location", LOCATION);
        data.put("email", "pikul.a@outlook.com");

        LogicLayer logicLayer = new LogicLayer();

        String currentURL = logicLayer.navigateToShareYourStoryPage()
                .fillShareYourStoryForm(data)
                .acceptTermsOfService()
                .clickSubmitAndGetURL();


        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(logicLayer.getSubmitButtonState());
    }

    @Test
    public void checkThatUserCannotSubmitQuestionIfTermsOfServiceIsNotChecked() {
        Map<String, String> data = new HashMap<>();
        data.put("text", STORY_TEXT);
        data.put("name", NAME);
        data.put("number", CONTACT_NUMBER);
        data.put("location", LOCATION);
        data.put("email", "pikul.a@outlook.com");

        LogicLayer logicLayer = new LogicLayer();

        String currentURL = logicLayer.navigateToShareYourStoryPage()
                .fillShareYourStoryForm(data)
                .acceptOverSixteenYearsOld()
                .clickSubmitAndGetURL();

        Assert.assertEquals(currentURL, PAGE_URL_FOR_ASSERT);
        Assert.assertTrue(logicLayer.getSubmitButtonState());
    }
}
