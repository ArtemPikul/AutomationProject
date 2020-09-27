package logiclayer;

import driver.DriverSingleton;
import pages.HomePage;
import pages.ShareYourStoryPage;

import java.util.Map;

public class LogicLayer {

    public LogicLayer navigateToShareYourStoryPage() {
        new HomePage(DriverSingleton.getDriver()).clickOnHeaderNewsLink()
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
        new ShareYourStoryPage(DriverSingleton.getDriver()).acceptOverSixteenYearsOldCondition();
        return this;
    }

    public LogicLayer acceptTermsOfService() {
        new ShareYourStoryPage(DriverSingleton.getDriver()).acceptTermsOfService();
        return this;
    }

    public String clickSubmitAndGetURL() {
        return new ShareYourStoryPage(DriverSingleton.getDriver()).clickSubmitButton().getCurrentPageURL();
    }

    public boolean getSubmitButtonState() {
        return new ShareYourStoryPage(DriverSingleton.getDriver()).getSubmitButtonState();
    }
}
