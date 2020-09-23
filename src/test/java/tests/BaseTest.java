package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.util.HashMap;

public abstract class BaseTest {

    protected WebDriver driver;

    protected HomePage homePage;
    protected NewsPage newsPage;
    protected ShareYourStoryPage shareYourStoryPage;

    private static final String BBC_URL = "https://www.bbc.com";

    @BeforeTest
    public void profileSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get(BBC_URL);
        this.homePage = new HomePage(driver);
        this.newsPage = new NewsPage(driver);
        this.shareYourStoryPage = new ShareYourStoryPage(driver);
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