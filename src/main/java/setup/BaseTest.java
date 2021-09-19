package setup;

import static java.lang.String.format;
import static properties.CloudTestProperties.PROJECT_NAME;
import static properties.CloudTestProperties.API_KEY;
import static properties.CloudTestProperties.APPIUM_HUB;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.PageObject;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    private static IPageObject pageObject;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return this.pageObject;
    }

    private static void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        pageObject = new PageObject(appType, appiumDriver);
    }

    public static DesiredCapabilities getDesiredCapabilities(
        String platformName, String browserName, String app,
        String udid, String appPackage, String appActivity, String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        if (app.endsWith(".apk")) {
            capabilities.setCapability(MobileCapabilityType.APP, (new File(app)).getAbsolutePath());
        }
        // Capabilities for test of Android native app on EPAM Mobile Cloud
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        capabilities.setCapability("bundleId", bundleId);

        return capabilities;
    }

    @Parameters({"appType", "udid", "platformName", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String appType,
                      @Optional("") String udid,
                      String platformName,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        DesiredCapabilities capabilities =
            getDesiredCapabilities(platformName, browserName, app, udid, appPackage, appActivity, bundleId);
        setAppiumDriver(capabilities);
        setPageObject(appType, appiumDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(DesiredCapabilities capabilities) {
        try {
            appiumDriver =
                new AppiumDriver(new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
