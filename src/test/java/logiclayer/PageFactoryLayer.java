package logiclayer;

import driver.DriverSingleton;
import pages.HomePage;
import pages.ShareYourStoryPage;

public class PageFactoryLayer {

    public static HomePage getHomePage() {
        return new HomePage(DriverSingleton.getDriver());
    }

    public static ShareYourStoryPage getShareYourStoryPage() {
        return new ShareYourStoryPage(DriverSingleton.getDriver());
    }

}
