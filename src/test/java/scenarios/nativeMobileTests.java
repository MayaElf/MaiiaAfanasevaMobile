package scenarios;

import entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativeTest.BudgetPage;
import pageObjects.nativeTest.NativePageObject;
import pageObjects.nativeTest.RegistrationPage;
import properties.MobileDataProvider;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(dataProvider = "nativeDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"native"},
            description = "Make sure that you are on the BudgetActivity page")
    public void RegistrationTest(User user, String budgetActivity) {
        NativePageObject nativePageObject = (NativePageObject) getPo().getPageObject();
        RegistrationPage registrationPage = nativePageObject.openRegistrationPage();
        registrationPage.register(user, getDriver());
        BudgetPage budgetPage = nativePageObject.login(user);
        budgetPage.waitForBudgetPageIsLoaded();
        Assert.assertEquals(budgetPage.getBudgetPageName(), budgetActivity);
    }
}
