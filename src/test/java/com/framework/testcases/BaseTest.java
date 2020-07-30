package com.framework.testcases;

import com.framework.pages.Page;
import com.framework.util.Testutil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/*
 Created by Lav Sharma
 Date :- 26th July 2020
 */

public class BaseTest {


    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;
    static Properties prop;
    static String pathOfFile = "/config.properties";

    @BeforeTest
    public void setup() {

        try {
            prop = new Properties();

            FileInputStream inputfile = new FileInputStream(System.getProperty("user.dir") + "/src" + pathOfFile + "");

            prop.load(inputfile);

            String browsername = prop.getProperty("browser");
            if (browsername.equals("chrome")) {
                System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
                driver = new ChromeDriver();
            }
            if (browsername.equals("firefox")) {
                System.getProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
                driver = new FirefoxDriver();
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("IMDB_url"));

            //Create of page class and instantiate the page class
            page = new Page(driver, wait);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void teardown() {
        driver.quit();
    }


}
