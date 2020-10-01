package com.cucumber.junit.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.cucumber.junit.pages.PageProvider.newsPage;
import static org.assertj.core.api.Assertions.assertThat;

public class NewsPageSteps {

    @And("the user goes to \"Coronavirus\" tab on \"News\" page")
    public void goToCoronavirusPage() {
        newsPage.clickOnCoronavirusTabLink();
    }

    @Then("the latest posted article is {string}")
    public void verifyThatExpectedArticleHeadlineIsMatch(String expectedHeadline) {
        assertThat(newsPage.getExpectedArticleHeadlineText())
                .overridingErrorMessage("Article with expected headline is not displayed")
                .isEqualTo(expectedHeadline);
    }

}
