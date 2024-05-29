package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AreaOfInterestPage {
    private final WebDriverWait wait;

    public AreaOfInterestPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void clickToSkipButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.interticket.budapest13:id/skip\"]"))).click();
    }
}