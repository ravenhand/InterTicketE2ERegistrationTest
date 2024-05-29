package pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationFieldPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegistrationFieldPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void fillRegistrationField(String firstName, String lastName, String email, String password, String confirmPassword) {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.interticket.budapest13:id/firstName\"]")));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.interticket.budapest13:id/lastName\"]"));
        lastNameField.sendKeys(lastName);
        WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.interticket.budapest13:id/email\"]"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.interticket.budapest13:id/newPassword\"]"));
        passwordField.sendKeys(password);
        WebElement confirmPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.interticket.budapest13:id/newPasswordConfirmation\"]"));
        confirmPasswordField.sendKeys(confirmPassword);
        WebElement dataProcessingPolicyCheckBox = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"com.interticket.budapest13:id/acceptDPPolicyCheckbox\"]"));
        dataProcessingPolicyCheckBox.click();
        scrolling();
        WebElement termsAndConditionsCheckBox = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"com.interticket.budapest13:id/acceptTCCheckbox\"]"));
        termsAndConditionsCheckBox.click();
        WebElement nextButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.interticket.budapest13:id/next\"]"));
        nextButton.click();
    }

    public void scrolling() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }
}