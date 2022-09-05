package pages;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import pages.base.BasePage;

public class TripSummaryPage extends BasePage {

    private static final String  departureTime = "com.m.qr:id/from_time"; // Both holds time in text as HH:MM
    private static final String  arrivalTime = "com.m.qr:id/to_time";
    
    @Step("Uçuş saatlerini arama sonuçlarına göre karşılaştır")
    public void controlFlightTimes(){
        logger.info("Uçuş saatleri kontrol ediliyor.");
        logger.info("Kayıtlı uçuş saati : " + BasePage.departureTime);
        logger.info("Kayıtlı varış saati : " + BasePage.arrivalTime);
        Assert.assertEquals(methods.getTextFromElementWithLocator(departureTime), BasePage.departureTime);
        Assert.assertEquals(methods.getTextFromElementWithLocator(arrivalTime), BasePage.arrivalTime);
    }
    
}
