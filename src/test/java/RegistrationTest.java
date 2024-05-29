import DriverFactory.driverSettings;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class RegistrationTest extends driverSettings {

    @Test
    @Description("This test demonstrates how to search for the InterTicket application in the Google Play Store, install it, register, and then confirm the registration.")
    public void E2ERegistrationTest() throws MalformedURLException, URISyntaxException {
        HomePage homePage = new HomePage(wait);
        homePage.clickSearchField();

        SearchPage searchPage = new SearchPage(wait);
        searchPage.searchApp(searchPage.getTestAppName());
        searchPage.startSearch();

        ResultPage resultPage = new ResultPage(wait, waitLong);
        Assert.assertTrue(resultPage.getInterTicketApp().isDisplayed() && resultPage.getInterTicketApp().isEnabled());
        resultPage.installInterTicketApp();

        AppPage appPage = new AppPage(wait);
        appPage.clickToNotAllowButton();
        appPage.clickToUserProfileButton();

        UserProfilePage userProfilePage = new UserProfilePage(wait);
        userProfilePage.clickToRegisterNowLink();

        RegistrationFieldPage registrationFieldPage = new RegistrationFieldPage(driver, wait);
        registrationFieldPage.fillRegistrationField("Elek", "Mekk", "elekm496@gmail.com", "Qwer1234", "Qwer1234");

        AreaOfInterestPage areaOfInterestPage = new AreaOfInterestPage(wait);
        areaOfInterestPage.clickToSkipButton();

        CompleteRegistrationPage completeRegistrationPage = new CompleteRegistrationPage(driver, waitLong);
        completeRegistrationPage.clickToOkButton();

        EmailAppPage emailAppPage = new EmailAppPage(driver, wait);
        emailAppPage.startEmailApp();
        emailAppPage.clickToGotItButton();
        emailAppPage.clickToTakeMeToGmailButton();
        emailAppPage.clickToDoNotAllowButton();
        emailAppPage.clickCloseButton();
        emailAppPage.clickToConfirmationEmail();
        emailAppPage.clickToMoreOptions();
        emailAppPage.clickToMoveTo();
        emailAppPage.clickToCancel();
        emailAppPage.clickToDetails();
        //emailAppPage.clickToConfirm();    --> For full test, delete the double slash
    }
}