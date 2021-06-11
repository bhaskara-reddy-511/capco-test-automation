package com.capco.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.awaitility.core.ConditionTimeoutException;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

import static org.awaitility.Awaitility.with;

public class BasePage extends PageObject {

    public void waitForOrFailWithProgress(long pollInterval, long duration, String waitingMessage,
                                          Callable<Boolean> conditionEvaluator, String errorMessage){

        try {
            with().pollInterval(pollInterval, TimeUnit.MILLISECONDS).await()
                    .atMost(duration, TimeUnit.MILLISECONDS)
                    .until(() -> {
                        return conditionEvaluator.call();
                    });
        }catch(ConditionTimeoutException ex){
            fail(errorMessage + " " +ex);
        }
    }

    public void waitForElementToBeLoaded(WebElementFacade element,String errorMessage){
        waitForOrFailWithProgress(1000, 50000, "Waiting for element to load" ,
                element::isDisplayed,errorMessage);
    }
}
