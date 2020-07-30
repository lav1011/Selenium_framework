package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
/*
 Created by Lav Sharma
 Date :- 26th July 2020
 */

public class ImdbPage extends BasePage {

    public ImdbPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    //Imdb Page Locators

    By SearchName = By.xpath("//*[@placeholder='Search IMDb']");
    By ClickingDirectorName = By.xpath("(.//a[text()='Steven Spielberg'])[1]");
    By SearchButton = By.xpath("//*[@id='suggestion-search-button']");
    By Directorname = By.xpath("(.//*[@class='itemprop'])[1]");
    By Producertab = By.xpath(".//*[@id='filmo-head-producer']");
    By Directortab = By.xpath(".//*[@id='filmo-head-director']");
    By FetchingNames = By.xpath(".//*[starts-with(@id,'director-tt')]/b/a");


    //Utility methods or helper functions

    public String PageGetTitle() {

        return driver.getTitle();

    }

    public String checkDirectorName() {

        return driver.findElement(Directorname).getText();
    }

    public void clickOnProducertab() {

        doclick(Producertab);
    }

    public void clickOnDirectortab() {

        doclick(Directortab);
    }

    public void searchname(String Directorname) {
        dosendkeys(SearchName, Directorname);
    }

    public void clickOnSearchButton() {
        doclick(SearchButton);

    }

    public void clickingOnSearchedname() {
        doclick(ClickingDirectorName);
    }


    public void waitforloading() {
        waitforvisibility(Directorname);
    }

    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public List<WebElement> storingMovieName() {

        return driver.findElements(FetchingNames);
    }

}
