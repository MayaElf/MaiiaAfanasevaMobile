package scenarios;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.webTest.WebPageObject;
import properties.PageProperties;
import setup.BaseTest;

import java.util.List;
import java.util.Locale;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that there are some relevant results")
    public void WebTest() {
        PageObject pageObject = (PageObject) getPo();
        WebPageObject googlePage = (WebPageObject) pageObject.getPageObject();
        googlePage.openPage(PageProperties.GOOGLE_PAGE.getText());
        googlePage.search(PageProperties.EPAM_SEARCH.getText());
        List<WebElement> resultList = googlePage.getSearchResult();
        Assert.assertTrue(resultList.size() > 0);
        Assert.assertTrue(resultList.get(1).getText().toLowerCase(Locale.ROOT)
                .contains(PageProperties.EPAM_SEARCH.getText().toLowerCase(Locale.ROOT)));
    }

}
