package ee.home.mikem.Tests;

import ee.home.mikem.Libraries.Support;
import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Country;
import ee.home.mikem.Objects.DocumentType;
import org.junit.Test;

public class VeriffTest extends MainTest {

    @Test
    public void should_show_nocamera_screen_when_verifying_by_passport_without_camera(){

        // Check landing page is opened
        landingPage.checkPageIsOpened();

        // Enter full name
        landingPage.enterFullName("Full name");

        // Select country as Russia
        landingPage.selectDocumentCountry(Country.Russia);

        // Select document type as Passport
        landingPage.selectDocumentType(DocumentType.passport);

        // Tap Veriff me button
        landingPage.tapSubmit();

        // Get Verified page should be opened
        getVerifiedPage.checkPageIsOpened();

        // Passport as an option should be available
        getVerifiedPage.verificationOptionShouldBeEnabled(DocumentType.passport);

        // Tap Start button
        getVerifiedPage.tapStartButton();

        // No camera screen should be displayed
        noCameraPage.checkPageIsOpened();

        Support.pause(1);
    }
}
