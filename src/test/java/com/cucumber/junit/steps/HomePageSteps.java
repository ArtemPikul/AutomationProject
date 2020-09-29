package com.cucumber.junit.steps;

import com.cucumber.junit.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps {

    private final HomePage homePage = new HomePage();

    @Given("the user opens BBC website")
    public void openBBCWebsite() {
        homePage.openBBCWebsite();
    }

    @And("the user goes to \"News\" page")
    public void goToNewsPage() {
        homePage.clickOnHeaderNewsLink();
    }

}
