package com.cucumber.junit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//p/a/span")
    private List<WebElement> searchResultArticleNames;

    public String getFirstSearchResult() {
        return searchResultArticleNames.get(0).getText();
    }

}
