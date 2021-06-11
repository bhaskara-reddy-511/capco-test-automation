package com.capco.actions;

import com.capco.pages.SearchResultsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsActions {

     private SearchResultsPage searchResultsPage;

     public void verifySearchResultsReturnedRoundTrip(){
         searchResultsPage.loadedSearchResults();
         assertThat(searchResultsPage.getRoundTripFlights()).hasSizeGreaterThan(1);
     }


}
