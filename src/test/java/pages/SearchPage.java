package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private final WebDriverWait wait;

    public SearchPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public void searchApp(String testAppName) {
        WebElement searchBoxView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText")));
        searchBoxView.sendKeys(testAppName);
    }

    public String getTestAppName() {
        return "Budapest13 Smart City";
    }

    public void startSearch() {
        WebElement searchValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")));
        wait.until(ExpectedConditions.visibilityOf(searchValue));
        searchValue.click();
    }
}