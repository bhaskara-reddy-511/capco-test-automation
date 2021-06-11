package com.capco.actions;

import com.capco.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeActions {

     private HomePage homePage;

     public void enterValueInFromAirport(String airportValue){
         homePage.clickOnFromAirport();
         homePage.enterValue(airportValue);
         homePage.selectOnSearchResults();
     }

    public void enterValueInToAirport(String airportValue){
        homePage.clickOnToAirport();
        homePage.enterValue(airportValue);
        homePage.selectOnSearchResults();
    }

    public void clickOnAcceptButton(){
         homePage.clickOnAcceptButton();
    }

    public void selectFromDate(WebDriver driver, String fromDate){
        homePage.selectFromDate(driver, fromDate);
    }

    public void selectToDate(WebDriver driver, String fromDate){
        homePage.selectToDate(driver, fromDate);
    }

    public void clickOnSearchButton(){
        homePage.clickOnSearchButton();
    }


}
