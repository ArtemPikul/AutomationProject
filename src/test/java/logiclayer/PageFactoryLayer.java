package logiclayer;

import driver.DriverSingleton;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultsPage;
import pages.ShareYourStoryPage;

public class PageFactoryLayer {

    public static HomePage getHomePage() {
        return new HomePage(DriverSingleton.getDriver());
    }

    public static ShareYourStoryPage getShareYourStoryPage() {
        return new ShareYourStoryPage(DriverSingleton.getDriver());
    }

    public static NewsPage getNewsPage() {
        return new NewsPage(DriverSingleton.getDriver());
    }

    public static SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(DriverSingleton.getDriver());
    }

}
