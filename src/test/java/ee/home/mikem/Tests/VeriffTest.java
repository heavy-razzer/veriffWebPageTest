package ee.home.mikem.Tests;

import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Country;
import ee.home.mikem.Objects.DocumentType;
import org.junit.Test;

public class VeriffTest extends MainTest {

    // Happy flow
    @Test
    public void should_show_nocamera_screen_when_verifying_by_passport_without_camera(){

        // Check landing page is opened
        landingPage.checkPageIsOpened();

        // Enter full name
        landingPage.enterFullName("Happy flow user");

        // Select country as Russia
        landingPage.selectDocumentCountry(Country.Russia);

        // Select document type as Passport
        landingPage.selectDocumentType(DocumentType.passport);

        // Tap Veriff me button
        landingPage.tapSubmit();

        // Get Verified page should be opened
        getVerifiedPage.checkPageIsOpened();

        // Passport as an option should be available
        getVerifiedPage.verificationOptionShouldBeEnabled(DocumentType.passport, true);

        // Tap Start button
        getVerifiedPage.tapStartButton();

        // No camera screen should be displayed
        noCameraPage.checkPageIsOpened();
    }

    // Unhappy flow - we have error here: Drivers license tile is not displayed
    @Test
    public void should_disable_verification_when_verifying_by_id_without_id_reader(){

        // Check landing page is opened
        landingPage.checkPageIsOpened();

        // Enter full name
        landingPage.enterFullName("Unhappy flow user");

        // Select document type as Passport
        landingPage.selectDocumentType(DocumentType.drivingLicense);

        // Tap Veriff me button
        landingPage.tapSubmit();

        // Get Verified page should be opened
        getVerifiedPage.checkPageIsOpened();

        getVerifiedPage.selectDocumentCountry(Country.Algeria);

        getVerifiedPage.verificationOptionShouldBeEnabled(DocumentType.drivingLicense, false);
    }
}
