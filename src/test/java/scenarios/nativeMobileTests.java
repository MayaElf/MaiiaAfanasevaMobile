package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativeTest.BudgetPage;
import pageObjects.nativeTest.NativePageObject;
import pageObjects.PageObject;
import pageObjects.nativeTest.RegistrationPage;
import properties.PageProperties;
import properties.UserProperties;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Make sure that you are on the BudgetActivity page")
    public void RegistrationTest() {
        PageObject pageObject = (PageObject) getPo();
        NativePageObject nativePageObject = (NativePageObject) pageObject.getPageObject();
        RegistrationPage registrationPage = nativePageObject.openRegistrationPage();
        registrationPage.register(new UserProperties().getUser(), getDriver());
        BudgetPage budgetPage = nativePageObject.login(new UserProperties().getUser());
        budgetPage.waitForBudgetPageIsLoaded();
        Assert.assertEquals(budgetPage.getBudgetPageName(), PageProperties.BUDGET_ACTIVITY.getText());
    }
}
