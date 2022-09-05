package pages;

import com.thoughtworks.gauge.Step;
import pages.base.BasePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FlightSearchPage extends BasePage {
    
    
    
    // New Version
    private static final String oneWaySelectionAccessibilityID = "One-way";
    
    private static final String departDestination = "com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder";
    private static final String arrivalDestination = "com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_holder";
    
    private static final String destinationSearchTextBox = "com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext";
    private static final String destinationSearchResults = "com.m.qr:id/rvmp_item_ond_selection_list_root_view";  // get returns to List<MobileElement>
    
    private static final String departureDateSelectionButton = "com.m.qr:id/rvmp_fragment_rtow_flight_selection_date_holder_date_text_view";
    private static final String departureDateXPath = "//android.widget.TextView[@resource-id='com.m.qr:id/rvmp_booking_calendar_day_text_view' and @text='";
    private static final String departureDateConfirmationButton = "com.m.qr:id/fragment_calendar_confirm_button";
    private static final String searchButton = "com.m.qr:id/rvmp_booking_search_flights_button";
    
    
    @Step("One-way tabını seç.")
    public void selectOneWayTab(){
        methods.clickElementByAccessibilityID(oneWaySelectionAccessibilityID);
    }
    
    @Step("Kalkış yeri seçimine tıkla")
    public void clickFromDestination(){
        methods.clickElement(departDestination);
    }
    
    @Step("Varış yeri seçimine tıkla")
    public void clickToDestination(){
        methods.clickElement(arrivalDestination);
    }
    
    @Step("<text> textini konum aramasına yaz ve rastgele bir element seç")
    public void sendKeysToDestinationSearchBox(String text) throws InterruptedException {
        methods.sendKeysToElement(destinationSearchTextBox, text);
        waitForGivenSeconds(1);
        methods.clickRandomElement(destinationSearchResults);
    }
    
    
    @Step("Uçuş tarihi seçimine tıkla")
    public void clickOnDepartureDate(){
        methods.clickElement(departureDateSelectionButton);
    }
    
    @Step("<days> gün sonranın tarihini seç")
    public void selectDepartureDate(int days) throws InterruptedException {

        final DateFormat dateFormat = new SimpleDateFormat("dd");
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        Date nextDate = cal.getTime();
        methods.clickElement(departureDateXPath+dateFormat.format(nextDate)+"']");
    
        methods.waitBySeconds(2);
        methods.clickElement(departureDateConfirmationButton);
        
        // TODO add swipe and if else
/*        if(month.format(nextWeeksDate)>month.format(currentDate)){
            // swipe
        }else{}
        // Select the date*/
    }
    
    @Step("Uçuş aramasına tıkla")
    public void clickOnSearchButton(){
        methods.clickElement(searchButton);
    }
    
}
