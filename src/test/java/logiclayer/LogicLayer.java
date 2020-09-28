package logiclayer;

import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultsPage;
import pages.ShareYourStoryPage;

import java.util.List;
import java.util.Map;

public class LogicLayer {

    private final HomePage homePage = PageFactoryLayer.getHomePage();
    private final ShareYourStoryPage shareYourStoryPage = PageFactoryLayer.getShareYourStoryPage();
    private final NewsPage newsPage = PageFactoryLayer.getNewsPage();
    private final SearchResultsPage searchResultsPage = PageFactoryLayer.getSearchResultsPage();

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

    public LogicLayer navigateToNewsPage() {
        homePage.clickOnHeaderNewsLink();
        return this;
    }

    public LogicLayer searchByKeyword(String searchQuery) {
        homePage.searchByKeyword(searchQuery);
        return this;
    }

    public String clickSubmitAndGetURL() {
        return shareYourStoryPage.clickSubmitButton().getCurrentPageURL();
    }

    public String getExpectedArticleHeadlineText() {
        return newsPage.getExpectedArticleHeadlineText();
    }

    public String getHeadlineArticleCategoryText() {
        return newsPage.getHeadlineArticleCategoryText();
    }

    public String getFirstSearchResult() {
        return searchResultsPage.getFirstSearchResult();
    }

    public boolean getSubmitButtonState() {
        return shareYourStoryPage.getSubmitButtonState();
    }

    public List<WebElement> getSecondaryArticleHeadlinesList() {
        return newsPage.getSecondaryArticleHeadlinesLIst();
    }


}
