package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
    static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        setup();
    }


    public static void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APPLICATION_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel API 28");
        caps.setCapability("appPackage","io.appium.android.apis");
        caps.setCapability("appActivity",".app.Animation");

        URL url=new URL("http://localhost:4723/wd/hub");
        URL url2=new URL("http://127.0.0.1:4723/wd/hub");
        URL url3=new URL("http://0.0.0.0:4723/wd/hub");

        driver=new AndroidDriver(url2,caps);

        driver.findElementByAccessibilityId("Fade in").click();
        Thread.sleep(500);
        driver.findElementByAccessibilityId("List dialog").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='Command one']").click();

    }
}
