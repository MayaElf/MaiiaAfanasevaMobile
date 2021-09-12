package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.webTest.WebPageObject;
import properties.MobileDataProvider;
import setup.BaseTest;

import java.util.List;
import java.util.Locale;

public class webMobileTests extends BaseTest {
    private static final int ZERO = 0;
    private static final int THREE = 3;



    @Test(dataProvider = "webDataProvider",
            dataProviderClass = MobileDataProvider.class,
            groups = {"web"},
            description = "Make sure that there are some relevant results")
    public void WebTest(String googlePageStr, String search) {
        WebPageObject googlePage = (WebPageObject) getPo().getPageObject();
        googlePage.openPage(googlePageStr);
        googlePage.search(search);
        List<WebElement> resultList = googlePage.getSearchResult();
        for (int i = ZERO; i < THREE; i++) {
            Assert.assertTrue(resultList.get(i).getText().toLowerCase(Locale.ROOT)
                    .contains(search.toLowerCase(Locale.ROOT)));
        }
    }
}
