package com.cucumber.junit.steps;

import com.cucumber.junit.pages.CoronavirusPage;
import io.cucumber.java.en.And;

public class CoronavirusPageSteps {

    private final CoronavirusPage coronavirusPage = new CoronavirusPage();

    @And("the user goes to \"Share your story\" page")
    public void goToShareYourStoryPage() {
        coronavirusPage.clickOnYourCoronavirusStoriesLink();
        coronavirusPage.clickOnShareWithBBCLink();
    }

}
