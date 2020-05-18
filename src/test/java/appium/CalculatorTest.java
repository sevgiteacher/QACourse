package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    static AppiumDriver driver;
    static WebDriverWait wait;

    public static MobileElement waitForVisible(By by){
        wait=new WebDriverWait(driver,10);
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public static void main(String... args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel API 28");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset",true);

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

        waitForVisible(By.id("com.android.calculator2:id/digit_7")).click();
        waitForVisible(By.id("com.android.calculator2:id/op_add")).click();
        waitForVisible(By.id("com.android.calculator2:id/digit_9")).click();
        waitForVisible(By.id("com.android.calculator2:id/eq")).click();
        String result = waitForVisible(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals("16",result);

    }
}
