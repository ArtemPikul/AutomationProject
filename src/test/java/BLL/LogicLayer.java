package BLL;

import pages.ShareYourStoryPage;
import tests.BaseTest;

import java.util.HashMap;

public class LogicLayer extends BaseTest {

    public static void navigateToShareYourStoryPage() {
        homePage.clickOnHeaderNewsLink()
                .clickOnCoronavirusTabLink()
                .clickOnYourCoronavirusStoriesLink()
                .clickOnShareWithBBCLink();
    }

    public static void fillShareYourStoryForm(HashMap<String, String> map) {
        ShareYourStoryPage.Form submitForm = new ShareYourStoryPage.Form();
        submitForm.FillForm(map);
    }

    public static void acceptOverSixteenYearsOld() {
        shareYourStoryPage.acceptOverSixteenYearsOldCondition();
    }

    public static void acceptTermsOfService() {
        shareYourStoryPage.acceptTermsOfService();
    }

    public static String clickSubmitAndGetURL() {
        return shareYourStoryPage.clickSubmitButton().getCurrentPageURL();
    }

    public static boolean getSubmitButtonState() {
        return shareYourStoryPage.getSubmitButtonState();
    }
}
