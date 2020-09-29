package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static final long WAIT_TIMEOUT = 15;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void waitForElementVisibility(long timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageReadyState(long timeout) {
        new WebDriverWait(DriverManager.getDriver(), timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public String getCurrentPageURL() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public boolean isPageWithURLDisplayed(String expectedURL) {
        return getCurrentPageURL().equals(expectedURL);
    }

}
