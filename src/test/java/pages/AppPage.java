package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppPage {

    private final WebDriverWait wait;

    public AppPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void clickToNotAllowButton() {
        WebElement notAllowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")));
        notAllowButton.click();
    }

    public void clickToUserProfileButton() {
        WebElement userProfileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"User profile\"]")));
        userProfileButton.click();
    }
}