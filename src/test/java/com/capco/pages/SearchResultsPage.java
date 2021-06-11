package com.capco.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class SearchResultsPage extends BasePage {

    @FindBy(id="searchResultsList")
    WebElementFacade searchResults;

    @FindBy(css="div.resultWrapper")
    List<WebElementFacade> flightResults;

    @FindBy(css="ol.flights li.flight")
    WebElementFacade roundTripFlights;

    public void loadedSearchResults(){
        waitForElementToBeLoaded(searchResults,"Search Results are not loaded");
    }

    public List<WebElement> getRoundTripFlights(){
        waitForElementToBeLoaded(flightResults.get(0),"Search Results are not loaded");
        Optional<WebElementFacade> flightResultList = flightResults.stream().findFirst();
        List<WebElement> filghtList = null;
        if(flightResultList.isPresent()){
            filghtList = flightResultList.get().findElements(By.cssSelector("ol.flights li.flight"));
        }
        return filghtList;
    }


}
