package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultsPage;

public abstract class BaseTest {

    protected WebDriver driver;

    private static final String BBC_URL = "https://www.bbc.com";

    @BeforeTest
    public void profileSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get(BBC_URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }



}