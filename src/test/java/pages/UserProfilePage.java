package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    private final WebDriverWait wait;

    public UserProfilePage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void clickToRegisterNowLink() {
        WebElement registerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.interticket.budapest13:id/registrationLink\"]")));
        registerLink.click();
    }
}