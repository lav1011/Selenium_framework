package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 Created by Lav Sharma
 Date :- 26th July 2020
 */


public class Page {

    public WebDriver driver;

    public WebDriverWait wait;


    //Page Class Constructor

   public Page(WebDriver driver,WebDriverWait wait){

       this.driver=driver;
       this.wait=wait;
    }

    //Create a Java Generics Which returns a new page

    public <Tpage extends BasePage> Tpage getInstance(Class<Tpage>pageClass){

       try {
           return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
       }
       catch (Exception e ){
           e.printStackTrace();
           return null;
       }
    }

}


