package logiclayer;

import pages.HomePage;
import pages.ShareYourStoryPage;

import java.util.Map;

public class LogicLayer {

    private final HomePage homePage = PageFactoryLayer.getHomePage();
    private final ShareYourStoryPage shareYourStoryPage = PageFactoryLayer.getShareYourStoryPage();

    public LogicLayer navigateToShareYourStoryPage() {
        homePage.clickOnHeaderNewsLink()
                .clickOnCoronavirusTabLink()
                .clickOnYourCoronavirusStoriesLink()
                .clickOnShareWithBBCLink();
        return this;
    }

    public LogicLayer fillShareYourStoryForm(Map<String, String> data) {
        ShareYourStoryPage.Form submitForm = new ShareYourStoryPage.Form();
        submitForm.FillForm(data);
        return this;
    }

    public LogicLayer acceptOverSixteenYearsOld() {
        shareYourStoryPage.acceptOverSixteenYearsOldCondition();
        return this;
    }

    public LogicLayer acceptTermsOfService() {
        shareYourStoryPage.acceptTermsOfService();
        return this;
    }

    public String clickSubmitAndGetURL() {
        return shareYourStoryPage.clickSubmitButton().getCurrentPageURL();
    }

    public boolean getSubmitButtonState() {
        return shareYourStoryPage.getSubmitButtonState();
    }
}
