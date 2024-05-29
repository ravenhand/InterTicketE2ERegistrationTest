package DriverFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class driverSettings {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitLong;
    protected Duration explicitWaitTimeoutInSeconds = Duration.ofSeconds(10);
    protected Duration installDurationInSeconds = Duration.ofSeconds(60);
    protected String testAppPackage = "com.interticket.budapest13";
    protected String testAppActivity = "com.interticket.smartcity.ui.MainActivity";

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName", "Pixel_PlayStore_Test");
        caps.setCapability("appPackage", "com.android.vending");
        caps.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        caps.setCapability("APP_WAIT_ACTIVITY", ".AssetBrowserActivity");
        caps.setCapability("APPIUM_VERSION", "9.2.2");

        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        this.wait = new WebDriverWait(driver, explicitWaitTimeoutInSeconds);
        this.waitLong = new WebDriverWait(driver, installDurationInSeconds);
    }

    @BeforeMethod
    public void uninstallAppIfExists() throws IOException, InterruptedException {
        final Process p = Runtime.getRuntime().exec("adb uninstall " + testAppPackage);

        new Thread(() -> {
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;

            try {
                while ((line = input.readLine()) != null)
                    System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        p.waitFor();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}