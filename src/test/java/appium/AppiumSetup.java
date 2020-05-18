package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppiumSetup {

    private static final Properties locatorId = new Properties();
    private static final Properties locatorType = new Properties();
    private static final Properties apps=new Properties();

    public static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;

    @Before
    public void setDriver() {
        try {
            initProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APPLICATION_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel API 28");
        caps.setCapability("appPackage",apps.getProperty("packageName"));
        caps.setCapability("appActivity",apps.getProperty("activity"));

        URL url= null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
            //        following URLs doing same issue. you can prefer which u want
//        URL url2=new URL("http://127.0.0.1:4723/wd/hub");
//        URL url3=new URL("http://0.0.0.0:4723/wd/hub");

            driver=new AndroidDriver(url,caps);
            wait=new WebDriverWait(driver,10);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void initProperties() throws IOException {
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream("locatorId.properties");
        locatorId.load(inputStream);

        InputStream inputStream2=getClass().getClassLoader().getResourceAsStream("locatorType.properties");
        locatorType.load(inputStream2);

        InputStream inputStream3=getClass().getClassLoader().getResourceAsStream("apps.properties");
        apps.load(inputStream3);
    }

    @After
    void quit() {
        driver.quit();
    }


    public static WebElement waitForPresence(By path){
        return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(path));
    }

    public static WebElement locateElements(String typeOrId){
        String id = locatorId.getProperty(typeOrId);
        String type = locatorType.getProperty(typeOrId);

        WebElement element;

        switch (type){
            case "xpath":
                element = waitForPresence(By.xpath(id));
                break;
            case "id":
                element = waitForPresence(By.id(id));
                break;
            case "desc":
                element = waitForPresence(new MobileBy.ByAccessibilityId(id));
                break;
            case "name":
                element = waitForPresence(By.name(id));
                break;
            case "linktext":
                element = waitForPresence(By.linkText(id));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return element;
    }

}
