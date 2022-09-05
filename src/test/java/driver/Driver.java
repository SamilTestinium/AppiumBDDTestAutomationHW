package driver;


import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static final Logger logger = LogManager.getLogger(Driver.class);
    
    private static final String deviceName = "TA91600CQ1";
//    private static final String deviceName = "emulator-5554";
    protected static final String packageName = "com.m.qr";
    private static final String platformName = "android";
    private static final String activityName = "com.m.qr.home.onboarding.ui.OnBoardingActivity";
    
    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
    
        switch (platformName.toLowerCase()){
            case "android": {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setPlatform(Platform.ANDROID);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, packageName);
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityName);
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
                
                appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            }
            case "ios": {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setPlatform(Platform.IOS);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"PLATFORMVERSION");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"DEVICENAME");
                capabilities.setCapability(MobileCapabilityType.UDID,"UDID");
                capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"BUNDLEID");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
                appiumDriver = new IOSDriver<>( new URL("http://127.0.0.1:4723/wd/hub") ,capabilities);
                break;
            }
            default:
                logger.error("Platform name is incorrect.");
        }
        
    }
    
    @AfterScenario
    public void afterScenario(){
        appiumDriver.quit();
    }
}
