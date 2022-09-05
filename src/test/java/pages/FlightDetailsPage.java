package pages;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import pages.base.BasePage;

public class FlightDetailsPage extends BasePage {
    
    // Control
    private static final String cabinClassText = "com.m.qr:id/rvmp_activity_flight_details_cabin_class_text_view";
    
    // Functional
    private static final String selectionButton = "com.m.qr:id/rvmp_activity_flight_details_select_button";

    // TODO maybe a swipe and a reverse one to make the selection.
    
    @Step("Ekonomi sınıfı seçildiğinden emin ol")
    public void controlCabinClass(){
        methods.isElementDisplayed(cabinClassText);
        Assert.assertTrue(methods.getTextFromElementWithLocator(cabinClassText).contains("Economy"));
    }
    
    @Step("Ekonomi sınıfı seçimini onaylamaya tıkla")
    public void clickFairConfirmationButton(){
        methods.clickElement(selectionButton);
    }
}
