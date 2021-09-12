package pageObjects.webTest;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nativeTest.BasePage;

import java.util.List;

public class WebPageObject extends BasePage {

    @FindBy(xpath = "//div[@aria-level='3']")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public WebPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }


    public WebPageObject openPage(String url) {
        appiumDriver.navigate().to(url);
        new WebDriverWait(appiumDriver, 10).until(
                wd -> ((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        return this;
    }

    public WebPageObject search(String searchStr) {
        searchField.sendKeys(searchStr);
        searchField.sendKeys(Keys.ENTER);
        new WebDriverWait(appiumDriver, 20).until(
                wd ->((JavascriptExecutor) wd)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
        return this;
    }

    public List<WebElement> getSearchResult() {
        return searchResultList;
    }
}
