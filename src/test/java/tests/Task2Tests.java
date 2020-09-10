package tests;

import org.testng.annotations.Test;

public class Task2Tests extends BaseTest {

    private static final String STORY_TEXT = "test story text";
    private static final String NAME = "Name";
    private static final String EMAIL = "invalid email";
    private static final String CONTACT_NUMBER = "+380112223344";
    private static final String LOCATION = "Kyiv";

    @Test
    public void checkThatUserCannotSubmitQuestionIfOneOfTheFieldsHasInvalidData() {
        getHomePage().clickOnHeaderNewsLink();
        getBasePage().waitForPageReadyState(15);
        getBasePage().waitForElementVisibility(15, getNewsPage().getSignInPopUp());
        getNewsPage().clickOnMaybeLaterOptionInSignInPopup()
                .clickOnCoronavirusTabLink();
        getBasePage().waitForPageReadyState(15);
        getCoronavirusPage().clickOnYourCoronavirusStoriesLink()
                .clickOnShareWithBBCLink()
                .fillInStoryTextArea(STORY_TEXT)
                .fillInNameField(NAME)
                .fillInEmailField(EMAIL)
                .fillInContactNumberField(CONTACT_NUMBER)
                .fillInLocationField(LOCATION)
                .acceptNecessaryConditions()
                .clickSubmitButton();
    }

}
