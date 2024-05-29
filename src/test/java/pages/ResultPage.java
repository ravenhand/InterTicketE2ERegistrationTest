package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {
    private final WebDriverWait wait;
    private final WebDriverWait waitLong;

    public ResultPage(WebDriverWait wait, WebDriverWait waitLong) {
        this.wait = wait;
        this.waitLong = waitLong;
    }

    public WebElement getInterTicketApp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]")));
    }

    public void installInterTicketApp() {
        WebElement installInterTicketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View[2]")));
        installInterTicketButton.click();
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Open\"]")));
        installInterTicketButton.click();
    }
}