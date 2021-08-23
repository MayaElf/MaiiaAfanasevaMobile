package pageObjects.nativeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nativeTest.BasePage;

public class BudgetPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    private WebElement budgetActionBarText;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    private WebElement addExpenseBtn;

    public BudgetPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitForBudgetPageIsLoaded() {
        new WebDriverWait(appiumDriver, 60)
                .until(ExpectedConditions.visibilityOf(addExpenseBtn));
    }

    public String getBudgetPageName() {
        return budgetActionBarText.getText();
    }
}
