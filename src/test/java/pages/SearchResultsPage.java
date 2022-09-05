package pages;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import pages.base.BasePage;

import java.util.List;
import java.util.Random;

public class SearchResultsPage extends BasePage {
    
    
    // Control elements
    private static final String searchResultTitleSelectDepartureTextView = "com.m.qr:id/booking_activity_conversational_message";
    
    // Functional
    private static final String flightSearchResults = "com.m.qr:id/rvmp_item_search_result_root_view";
    private static final String departureTimes = "com.m.qr:id/rvmp_departure_time"; // should use index to get it
    private static final String arrivalTimes = "com.m.qr:id/rvmp_arrival_time"; // should use index to get it
    
    @Step("Uçuş arama sonuç ekranı textlerini kontrol et")
    public void controlSearchResultElements(){
        methods.isElementDisplayed(searchResultTitleSelectDepartureTextView);
    }
    
    @Step("Arama sonuçlarından rastgele bir uçuşa tıkla")
    public void clickRandomFlightSearchResult(){
        List<MobileElement> flightList = methods.getElementList(flightSearchResults);
    
        Random rand = new Random();
        int index = rand.nextInt(flightList.size()-1);
    
        List<MobileElement> departureTimeList = methods.getElementList(departureTimes);
        List<MobileElement> arrivalTimeList = methods.getElementList(arrivalTimes);
        
        BasePage.departureTime = methods.getTextFromElement(departureTimeList.get(index));
        BasePage.arrivalTime = methods.getTextFromElement(arrivalTimeList.get(index));
        
        flightList.get(index).click();
    }
    
}
