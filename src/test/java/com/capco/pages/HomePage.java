package com.capco.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    @FindBy(css="div.q-kF-origin")
    WebElementFacade fromAirport;

    @FindBy(css="div.q-kF-destination")
    WebElementFacade toAirport;

    @FindBy(css=".k_my-input")
    WebElementFacade inputField;

    @FindBy(css="div.JyN0-pres-item-default")
    WebElementFacade searchResults;

    @FindBy(xpath="//button[contains(@id, '-accept')]")
    WebElementFacade acceptButton;

    @FindBy(css="div.cQtq-input")
    WebElementFacade dateField;

    @FindBy(xpath="//span[contains(@class, '-from-date')]")
    WebElementFacade fromDate;

    @FindBy(xpath="//span[contains(@class, '-to-date')]")
    WebElementFacade toDate;

    @FindBy(css="div.onx_-days")
    WebElementFacade dateElements;

    @FindBy(xpath="//button[contains(@aria-label, 'Search')]")
    WebElementFacade searchButton;

    public void clickOnFromAirport(){
        fromAirport.waitUntilClickable().click();
    }

    public void clickOnToAirport(){
        toAirport.waitUntilClickable().click();
    }

    public void clickOnDateField(){
        dateField.waitUntilClickable().click();
    }

    public void enterValue(String value){
        inputField.waitUntilClickable().clear();
        inputField.sendKeys(value);
    }

    public void selectFromDate(WebDriver driver, String value){
        dateField.waitUntilClickable().click();
        waitForElementToBeLoaded(dateElements,"Date element is not loaded");
        driver.findElement(By.xpath("//div[contains(@aria-label, '"+value+"')]")).click();
    }

    public void selectToDate(WebDriver driver, String value){
        driver.findElement(By.xpath("//div[contains(@aria-label, '"+value+"')]")).click();
    }

    public void selectOnSearchResults(){
        searchResults.waitUntilClickable().click();
    }

    public void clickOnAcceptButton(){
        waitForElementToBeLoaded(acceptButton,"Cookies message is not loaded");
        acceptButton.waitUntilVisible().click();
    }

    public void clickOnSearchButton(){
        searchButton.waitUntilVisible().click();
    }


}
