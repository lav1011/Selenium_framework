package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/*
 Created by Lav Sharma
 Date :- 26th July 2020
 */

public class LetterboxdPage extends BasePage {


    public LetterboxdPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    //Locators for LetterboxdPage

    By SearchBar = By.xpath(".//*[@id='search-q']");
    By Searchbtn = By.xpath(".//*[@value='Search']");
    By ClickingFromSearchResult = By.xpath(".//*[@class='content']/h2/a");
    By ClickingProducerdropdown = By.xpath("//label[contains(text(),'Producer')]");
    By ClickonDirectorCategory = By.xpath(".//a[@href='/director/steven-spielberg/']");
    By WaitforDirectortag = By.xpath(".//*[@class='smenu' and label='Director']");
    By DirectorName = By.xpath("(//*[@class='contextual-title']/h1/text())[2]");
    By ListOfMovies = By.xpath(".//*[@class='poster-container']/div/div/a");


    //Utility methods or helper functions

    public String getpagetitle() {

        return driver.getTitle();
    }

    public void hitLetterboxdUrl(String url) {
        driver.get(url);
    }

    public String checkname() {

        return gettext(DirectorName);
    }

    public void isdisplayed() {

        driver.findElement(DirectorName).isDisplayed();
    }

    public void waitforloadingatStarting() {
        waitforvisibility(SearchBar);
    }

    public void clickingFromSearchResults() {
        doclick(ClickingFromSearchResult);
    }

    public void clickdropdown() {
        doclick(ClickonDirectorCategory);
    }

    public void hoverondropdown() {
        WebElement producerhover = driver.findElement(ClickingProducerdropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(producerhover).build().perform();

    }

    public void searchingdata(String name) {
        dosendkeys(SearchBar, name);
    }

    public void clickingsearchbtn() {
        doclick(Searchbtn);
    }

    public void directorCategory() {
        doclick(ClickonDirectorCategory);

    }

    public void wait(int time) {

        waitforinputtime(time);
    }

    public void waitfordirectortag() {
        waitforvisibility(WaitforDirectortag);
    }

    public void waitforproducertag() {
        waitforvisibility(ClickingProducerdropdown);
    }


    public List<WebElement> fetchingMovieTitle() {

        return driver.findElements(ListOfMovies);

    }


}
