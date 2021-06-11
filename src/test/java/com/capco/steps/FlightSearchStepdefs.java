package com.capco.steps;

import com.capco.actions.HomeActions;
import com.capco.actions.SearchResultsActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

public class FlightSearchStepdefs {

    @Managed
    WebDriver driver;

    @Steps
    HomeActions homeActions;

    @Steps
    SearchResultsActions searchResultsActions;

    @Given("I am on home page {string}")
    public void iAmOnHomePage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        homeActions.clickOnAcceptButton();
    }

    @When("I enter From {string} and To {string} airports")
    public void iEnterFromAndToAirports(String fromAirport, String toAirport) {
        homeActions.enterValueInFromAirport(fromAirport);
        homeActions.enterValueInToAirport(toAirport);
    }

    @And("I enter From Date {string} and To Date {string}")
    public void iEnterFromDateAndToDate(String fromDate, String toDate) {
        homeActions.selectFromDate(driver, fromDate);
        homeActions.selectToDate(driver, toDate);
    }

    @And("click on Search Button")
    public void clickOnSearchButton() {
        homeActions.clickOnSearchButton();
    }

    @Then("Verify Search Results returned round trip")
    public void verifySearchResultsReturnedRoundTrip() {
        searchResultsActions.verifySearchResultsReturnedRoundTrip();
    }

}
