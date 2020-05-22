package appium;
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.remote.MobileCapabilityType;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import java.net.MalformedURLException;
        import java.net.URL;

public class CallManagementTest {
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
        caps.setCapability("appPackage", "com.google.android.dialer");
        caps.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");
        caps.setCapability("noReset",true);
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

//        waitForVisible(By.xpath("//*[@text='Contacts']")).click();
//        waitForVisible(By.xpath("//*[@text='CREATE NEW CONTACT']")).click();
//        waitForVisible(By.id("com.android.contacts:id/left_button")).click();
//        waitForVisible(By.xpath("//*[@text='First name']")).click();
//        waitForVisible(By.xpath("//*[@text='First name']")).sendKeys("Appium"+ Keys.ENTER);
//        waitForVisible(By.xpath("//*[@text='Last name']")).sendKeys("Test");
//        waitForVisible(By.xpath("//*[@text='Phone']")).sendKeys("09123123141");
//        waitForVisible(By.id("com.android.contacts:id/editor_menu_save_button")).click();

        waitForVisible(By.xpath("//*[@text='Contacts']")).click();
        //first person saving
        waitForVisible(By.xpath("//*[@text='CREATE NEW CONTACT']")).click();
        //use after first person
//        waitForVisible(By.xpath("//*[@text='Create new contact']")).click();
        waitForVisible(By.xpath("//*[@text='First name']")).click();
        waitForVisible(By.xpath("//*[@text='First name']")).sendKeys("Appium");
        waitForVisible(By.xpath("//*[@text='Last name']")).click();
        waitForVisible(By.xpath("//*[@text='Last name']")).sendKeys("Test2");
        waitForVisible(By.id("com.android.contacts:id/editor_menu_save_button")).click();
        waitForVisible(By.xpath("//*[@text='Add phone number']")).click();
        waitForVisible(By.xpath("//*[@text='Phone']")).click();
        waitForVisible(By.xpath("//*[@text='Phone']")).sendKeys("09123123141");
        waitForVisible(By.id("com.android.contacts:id/editor_menu_save_button")).click();



    }
}

