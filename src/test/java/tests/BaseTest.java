package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public abstract class BaseTest {

    protected WebDriver chromeDriver;

    protected HomePage homePage;
    protected NewsPage newsPage;
    protected ShareYourStoryPage shareYourStoryPage;

    private static final String BBC_URL = "https://www.bbc.com";

    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\resources\\chromedriver.exe");
        this.chromeDriver = new ChromeDriver();
        this.homePage = new HomePage(chromeDriver);
        this.newsPage = new NewsPage(chromeDriver);
        this.shareYourStoryPage = new ShareYourStoryPage(chromeDriver);
    }

    @BeforeTest
    public void testsSetUp() {
        chromeDriver.manage().window().maximize();
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
