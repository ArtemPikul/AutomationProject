package com.cucumber.junit.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    private List<WebElement> articleHeadlineList;

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private List<WebElement> secondaryArticleHeadlinesList;

    @FindBy(xpath = "//a[@class='gs-c-section-link gs-c-section-link--truncate nw-c-section-link nw-o-link nw-o-link--no-visited-state']/span")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//a[@class='nw-o-link']/span[contains(text(), 'Coronavirus')]")
    private List<WebElement> coronavirusTabLink;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;

    public String getHeadlineArticleCategoryText() {
        return categoryList.get(0).getText();
    }

    public void clickOnCoronavirusTabLink() {
        coronavirusTabLink.get(0).click();
        waitForPageReadyState(WAIT_TIMEOUT);
    }

    public String getExpectedArticleHeadlineText() {
        waitForPageReadyState(WAIT_TIMEOUT);
        return articleHeadlineList.get(0).getText();
    }


    public void searchByKeyword(String keyword) {
        searchField.sendKeys(keyword, Keys.ENTER);
    }

}
