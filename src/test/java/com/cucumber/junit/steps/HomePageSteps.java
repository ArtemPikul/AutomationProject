package com.cucumber.junit.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.cucumber.junit.pages.PageProvider.homePage;

public class HomePageSteps {

    @Given("the user opens BBC website")
    public void openBBCWebsite() {
        homePage.openBBCWebsite();
    }

    @And("the user goes to \"News\" page")
    public void goToNewsPage() {
        homePage.clickOnHeaderNewsLink();
    }

}
