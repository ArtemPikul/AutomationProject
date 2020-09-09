package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultsPage;

public class BaseTest {

    private WebDriver chromeDriver;

    private static final String BBC_URL = "https://www.bbc.com";

    @BeforeTest
    public void checkSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get(BBC_URL);
    }

    @AfterMethod
    public void tearDown() {
        chromeDriver.close();
    }

    public BasePage getBasePage() {
        return new BasePage(chromeDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(chromeDriver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(chromeDriver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(chromeDriver);
    }

}
