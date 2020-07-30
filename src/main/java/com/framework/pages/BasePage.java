package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/*
 Created by Lav Sharma
 Date :- 26th July 2020
 */

public class BasePage extends Page {


    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    //Generics Utility methods

    public void doclick(By locator) {

        driver.findElement(locator).click();

    }

    public void dosendkeys(By locator, String text) {

        driver.findElement(locator).sendKeys(text);

    }

    public String gettext(By locator) {

        return driver.findElement(locator).getText();

    }

    public void waitforinputtime(int time) {

        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void checkisdisplayed(By locator) {

        driver.findElement(locator);
    }

    public void waitforvisibility(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
    }

}
