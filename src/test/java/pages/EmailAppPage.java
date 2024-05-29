package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class EmailAppPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EmailAppPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void startEmailApp() throws URISyntaxException, MalformedURLException {
        DesiredCapabilities caps = getDesiredCapabilities();

        Duration explicitWaitTimeoutInSeconds = Duration.ofSeconds(10);
        URI appiumServerUrl = new URI("http://127.0.0.1:4723/wd/hub");

        this.driver = new AndroidDriver(appiumServerUrl.toURL(), caps);
        this.wait = new WebDriverWait(driver, explicitWaitTimeoutInSeconds);
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName", "Pixel_PlayStore_Test");
        caps.setCapability("APP_WAIT_ACTIVITY", ".AssetBrowserActivity");
        caps.setCapability("APPIUM_VERSION", "9.2.2");
        caps.setCapability("appPackage", "com.google.android.gm");
        caps.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
        return caps;
    }

    public void clickToGotItButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/welcome_tour_got_it\"]"))).click();
    }

    public void clickToTakeMeToGmailButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_done\"]"))).click();
    }

    public void clickToDoNotAllowButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]"))).click();
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Close\"]"))).click();
    }

    public void clickToConfirmationEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.gm:id/viewified_conversation_item_view\" and contains(@text, \"Budapest13\")]\n"))).click();
    }

    public void clickToMoreOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@content-desc=\"More options\"])[3]"))).click();
    }

    public void clickToMoveTo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView/android.widget.LinearLayout[1]"))).click();
    }

    public void clickToCancel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button2"))).click();
    }

    public void clickToDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/upper_header\"])[1]"))).click();
    }

    public void clickToConfirm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Megerősítem\"]"))).click();
    }
}