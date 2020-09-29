package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String BBC_URL = "https://www.bbc.com";

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(), 'News')]")
    private WebElement newsLink;

    @FindBy(xpath = "//button[contains(text(), 'Maybe later')]")
    private WebElement signInPopupMaybeLater;

    public void openBBCWebsite() {
        DriverManager.getDriver().get(BBC_URL);
    }

    public void clickOnHeaderNewsLink() {
        newsLink.click();
        waitForPageReadyState(WAIT_TIMEOUT);
        try {
            signInPopupMaybeLater.click();
        } finally {

        }
    }

}
