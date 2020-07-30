package com.framework.testcases;

import com.framework.pages.ImdbPage;
import com.framework.pages.LetterboxdPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.*;
import java.util.regex.Pattern;
/*
 Created by Lav Sharma
 Date :- 26th July 2020
 */

public class IMDbTestCases extends BaseTest {


    @Test(priority = 1,description = " Parse movie data available for that director from the two sources and highlight the differences\n" +
            "between the two sources. The differences might be in the list of the actual movies (title names or differing titles) or\n" +
            "mismatch on any available attribute of the movie (like the year). We are using source 1 as IMDB and source 2 as Letterbox ")
    public void FetchingTheNameFromIMDb() throws InterruptedException {

        try {

            page.getInstance(ImdbPage.class).searchname("Steven Spielberg");
            page.getInstance(ImdbPage.class).clickOnSearchButton();
            page.getInstance(ImdbPage.class).clickingOnSearchedname();
            page.getInstance(ImdbPage.class).sleep(4000);
            page.getInstance(ImdbPage.class).clickOnProducertab();
            page.getInstance(ImdbPage.class).sleep(4000);
            page.getInstance(ImdbPage.class).clickOnDirectortab();
            List<WebElement> StoringTitles = page.getInstance(ImdbPage.class).storingMovieName();
            int Imdbcount = StoringTitles.size();
            List<String> ImdbMovieList = new ArrayList<>();
            for (int i = 0; i < Imdbcount; i++) {
                ImdbMovieList.add(StoringTitles.get(i).getText());
            }
            page.getInstance(LetterboxdPage.class).hitLetterboxdUrl(prop.getProperty("LetterBox_url"));
            page.getInstance(LetterboxdPage.class).waitforloadingatStarting();
            page.getInstance(LetterboxdPage.class).searchingdata("Steven Spielberg");
            page.getInstance(LetterboxdPage.class).clickingsearchbtn();
            page.getInstance(LetterboxdPage.class).wait(10);
            page.getInstance(LetterboxdPage.class).clickingFromSearchResults();
            page.getInstance(LetterboxdPage.class).wait(5);
            page.getInstance(LetterboxdPage.class).waitforproducertag();
            page.getInstance(ImdbPage.class).sleep(4000);
            page.getInstance(LetterboxdPage.class).hoverondropdown();
            page.getInstance(LetterboxdPage.class).wait(5);
            page.getInstance(LetterboxdPage.class).directorCategory();
            page.getInstance(LetterboxdPage.class).waitfordirectortag();
            List<WebElement> StoringTitlesfromLetterBox = page.getInstance(LetterboxdPage.class).fetchingMovieTitle();
            int LetterBoxMoviesCount = StoringTitlesfromLetterBox.size();
            List<String> LetterBoxMovieList = new ArrayList<>();
            for (int i = 0; i < LetterBoxMoviesCount; i++) {
                LetterBoxMovieList.add(StoringTitlesfromLetterBox.get(i).getAttribute("data-original-title").split(Pattern.quote("("))[0].trim());
            }
            System.out.println("Total Movies Directed by Spielberg in IMDb is :- " + ImdbMovieList.size());
            System.out.println(ImdbMovieList + "\n");
            System.out.println("Total Movies Directed by Spielberg in LetterBox is :- " + LetterBoxMovieList.size());
            System.out.println(LetterBoxMovieList + "\n");
            Collections.sort(ImdbMovieList);
            Collections.sort(LetterBoxMovieList);

            /*
             We need those movie titles which are unique in both the list.
              So fist we need to take a Union of both the list and remove the Common movie titles.
              Below is the logic which i have used to get the unique results.
             */
            Set<String> union = new HashSet<>(ImdbMovieList);
            union.addAll(LetterBoxMovieList);
            Set<String> intersection = new HashSet<>(ImdbMovieList);
            intersection.retainAll(LetterBoxMovieList);
            union.removeAll(intersection);
            System.out.println("\nFinal List is a difference between two List where The Imdb List has Movie Title which are Not present in Letter Box and Vice Versa ");
            System.out.println(union);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

