package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompleteRegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait waitLong;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement okButton;

    public CompleteRegistrationPage(WebDriver driver, WebDriverWait waitLong) {
        this.driver = driver;
        this.waitLong = waitLong;
        PageFactory.initElements(driver, this);
    }

    public void clickToOkButton() {
        waitLong.until(ExpectedConditions.visibilityOf(okButton)).click();
    }
}