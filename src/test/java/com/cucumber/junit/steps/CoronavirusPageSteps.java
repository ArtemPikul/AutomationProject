package com.cucumber.junit.steps;

import io.cucumber.java.en.And;

import static com.cucumber.junit.pages.PageProvider.coronavirusPage;

public class CoronavirusPageSteps {


    @And("the user goes to \"Share your story\" page")
    public void goToShareYourStoryPage() {
        coronavirusPage.clickOnYourCoronavirusStoriesLink();
        coronavirusPage.clickOnShareWithBBCLink();
    }

}
