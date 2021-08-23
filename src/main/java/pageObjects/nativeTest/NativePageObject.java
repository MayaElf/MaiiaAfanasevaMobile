package pageObjects.nativeTest;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject extends BasePage {

    private final static String APP_NAME = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerBtn;

    @AndroidFindBy(id = APP_NAME + "login_email")
    private WebElement emailInput;

    @AndroidFindBy(id = APP_NAME + "login_pwd")
    private WebElement passInput;

    public NativePageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationPage openRegistrationPage() {
        appiumDriver.hideKeyboard();
        registerBtn.click();
        return new RegistrationPage(appiumDriver);
    }

    public BudgetPage login(User user) {
        emailInput.sendKeys(user.getEmail());
        passInput.sendKeys(user.getPassword());
        appiumDriver.hideKeyboard();
        signInBtn.click();
        return new BudgetPage(appiumDriver);
    }

}
