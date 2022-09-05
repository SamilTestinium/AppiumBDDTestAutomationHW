package pages.base;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    
    protected static Logger logger = LogManager.getLogger(BasePage.class);
    protected static Methods methods = new Methods();
    protected static String departureTime;
    protected static String arrivalTime;
    
    @Step("<seconds> saniye kadar bekle")
    public void waitForGivenSeconds(int seconds) throws InterruptedException {
        methods.waitBySeconds(seconds);
    }
    
}
