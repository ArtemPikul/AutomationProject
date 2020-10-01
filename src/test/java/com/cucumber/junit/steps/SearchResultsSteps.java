package com.cucumber.junit.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;

import static com.cucumber.junit.pages.PageProvider.newsPage;
import static com.cucumber.junit.pages.PageProvider.searchResultsPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSteps {

    private String searchQuery = "";

    @When("the user searches for a category of headline article using search bar")
    public void getHeadlineArticleCategoryAndSearchForIt() {
        searchQuery = newsPage.getHeadlineArticleCategoryText();
        newsPage.searchByKeyword(searchQuery);
    }

    @Then("the first article found contains the search keyword")
    public void verifyThatFirstFoundArticleContainsSearchQuery() {
        String firstFoundArticle = searchResultsPage.getFirstSearchResult();
        assertThat(Arrays.asList(firstFoundArticle.split(" "))
                .contains(searchQuery))
                .overridingErrorMessage("Found article doesn't contain a search query.")
                .isTrue();
    }

}
