package pages;

import com.thoughtworks.gauge.Step;
import pages.base.BasePage;

public class WelcomePage extends BasePage {
    
    // TODO
    /** Push notif click misfires a lot.
     * Berlin and Istanbul airports might not match
     * How to combine tests into one step
     * Dynamic waiting*/
    
    // Controls
    private static final String welcomeScreenLocationServiceMainText = "com.m.qr:id/main_text";
    private static final String enableLocationButton = "com.m.qr:id/enable_location_button";
    private static final String welcomeMainText = "com.m.qr:id/page_text";
    private static final String pushNotificationConsentPopUp = "com.m.qr:id/push_consent_bg";
    
    // Functionals
    private static final String bookTab = "com.m.qr:id/nav_menu_book";
    private static final String locationServicePermSkipButton = "com.m.qr:id/skip_button";
    private static final String welcomeSliderSkipButton = "com.m.qr:id/onboarding_skip_button";
    private static final String pushNotifPermDeclineButton = "com.m.qr:id/push_consent_decline";
    
    @Step("Konum izin ekranını atla")
    public void skipLocationPermissionPage() {
        methods.clickElement(locationServicePermSkipButton);
    }
    
    @Step("Hoşgeldiniz sliderını atla")
    public void skipWelcomeSlider() {
        methods.isElementDisplayed(welcomeMainText);
        methods.clickElement(welcomeSliderSkipButton);
    }
    
    @Step("Bildirim izin pop upını kapat")
    public void closeNotificationPermissionPopUp() {
        methods.isElementDisplayed(pushNotificationConsentPopUp);
        methods.clickElement(pushNotifPermDeclineButton);
        
    }
    
    @Step("Location izninin ekranda olduğunu kontrol et.")
    public void controlIfApplicationStarted(){
        methods.isElementDisplayed(welcomeScreenLocationServiceMainText);
        methods.isElementDisplayed(enableLocationButton);
    }
    
    @Step("Bilet seçmek için booking tabına geç")
    public void selectBookingTab(){
        methods.clickElement(bookTab);
    }
}
