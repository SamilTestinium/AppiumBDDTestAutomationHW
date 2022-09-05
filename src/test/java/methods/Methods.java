package methods;

import driver.Driver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Methods extends Driver {
    
    protected static final Logger logger = LogManager.getLogger(Methods.class);
    
    WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
    
    public void waitBySeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds* 1000L);
    }
    
    public void sendKeysToElement(String locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(byClassifier(locator))).sendKeys(text);
        logger.info(locator + " elementine " + text + " texti gönderildi.");
    }
    
    public void clickElement(String locator){
        wait.until(ExpectedConditions.elementToBeClickable(byClassifier(locator))).click();
        logger.info(locator + " elementine tiklandi");
    }
    
    public void clickElementByAccessibilityID(String accessibilityID){
        //TODO can include both this and classifier in clickelementfun with switch case
        wait.until(ExpectedConditions.elementToBeClickable(appiumDriver.findElementsByAccessibilityId(accessibilityID).get(0))).click();
    }
    
    public void clickRandomElement(String locator){
        List<MobileElement> elementList = appiumDriver.findElements(byClassifier(locator));
        logger.info("Searched results total elements : " + elementList.size());
        
        Random rand = new Random();
        int index = rand.nextInt(elementList.size()-1);
        
        logger.info(elementList.get(index) + " is selected");
        wait.until(ExpectedConditions.elementToBeClickable(elementList.get(index))).click();
    }
    
    public List<MobileElement> getElementList(String locator){
        List<MobileElement> elementList = appiumDriver.findElements(byClassifier(locator));
        logger.info("Searched results total elements : " + elementList.size());
        return elementList;
    }
    
    public void isElementDisplayed(String id){
        logger.warn(id + " elementinin görünürlüğü kontrol ediliyor.");
        boolean elementIsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(byClassifier(id))).isDisplayed();
        Assert.assertTrue(elementIsDisplayed);
    }
    
    public String getTextFromElementWithLocator(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(byClassifier(locator))).getText();
    }
    
    public String getTextFromElement(MobileElement element){
        return element.getText();
    }
    
    public By byClassifier(String locatorString){
        if(locatorString.startsWith(packageName)){
            return By.id(locatorString);
        }else if(locatorString.startsWith("/")){
            return By.xpath(locatorString);
        }
        else{
            logger.error("Given locator is wrong : " + locatorString);
            throw new RuntimeException();
        }
    }
    
    //TODO Swipe
}
