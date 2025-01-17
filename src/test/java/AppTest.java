/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {
    private static final String BROWSER_NAME = "Safari";
    private static final long MAX_WAIT_PAGE_LOAD = 30;

    private static final int APPIUM_PORT = Integer.valueOf(System.getProperty("appiumPort", "4723"));
    private static final String UDID = System.getProperty("udid", "9b5425679b8d5d175af4d0a3477ae64a811287c9") ;
    private static final String WEBKIT_DEBUG_PORT = System.getProperty("webkitDebugProxyPort", "40002");
    private static final String WDA_SERVER_URL = System.getProperty("wdaServerUrl", "http://127.0.0.1:40001");

    /*
    private static final int APPIUM_PORT = Integer.valueOf(System.getProperty("appiumPort", "30001"));
    private static final String UDID = System.getProperty("udid", "9b5425679b8d5d175af4d0a3477ae64a811287c9") ;
    private static final String WEBKIT_DEBUG_PORT = System.getProperty("webkitDebugProxyPort", "30601");
    private static final String WDA_SERVER_URL = System.getProperty("wdaServerUrl", "http://127.0.0.1:30101");
    */


    /*
    private static final int APPIUM_PORT = Integer.valueOf(System.getProperty("appiumPort", "30002"));
    private static final String UDID = System.getProperty("udid", "00008020-000A19D80C82002E") ;
    private static final String WEBKIT_DEBUG_PORT = System.getProperty("webkitDebugProxyPort", "30602");
    private static final String WDA_SERVER_URL = System.getProperty("wdaServerUrl", "http://127.0.0.1:30102");
    */

    @Test
    void testSafariTest() throws MalformedURLException {
        WebDriver driver = null;

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iOS Device");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2.5");
            capabilities.setCapability(MobileCapabilityType.UDID, UDID);
            capabilities.setCapability("webkitDebugProxyPort", WEBKIT_DEBUG_PORT);
            capabilities.setCapability(IOSMobileCapabilityType.WEB_DRIVER_AGENT_URL, WDA_SERVER_URL);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(IOSMobileCapabilityType.START_IWDP, true);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);

            System.out.println("Starting Driver");
            driver = new IOSDriver<>(new URL("http://127.0.0.1:" + APPIUM_PORT + "/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(MAX_WAIT_PAGE_LOAD, TimeUnit.SECONDS);
            System.out.println("Driver Created");

            driver.get("https://mobile.nytimes.com");
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
            assertNotNull(pageTitle);
            
        } finally {
            if (driver != null) {
                driver.close();
            }
        }
    }
}
