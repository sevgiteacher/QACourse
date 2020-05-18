package appium;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static appium.AppiumSetup.driver;
import static appium.AppiumSetup.locateElements;

public class MobileHelper {

    public static void scrollToWithIdHelper(String text,String uiselector){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+uiselector+"\")).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"));"));
    }

    public static void scrollToHelper(String text){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollTextIntoView(\""+text+"\")"));
//        driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
//                        + "new UiSelector().text(\""+text+"\"));"));


    }

    public static void scrollHorizontalHelper(String text){
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".setAsHorizontalList().scrollTextIntoView(\""+text+"\")"));
//        driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView("
//                        + "new UiSelector().text(\""+text+"\"))"));
//        driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"android:id/tabs\")).setAsHorizontalList().scrollIntoView("
//                        + "new UiSelector().text(\""+text+"\"))"));
    }

    public static void mobilePressBackHelper(){
        driver.navigate().back();
    }

    public static void mobilePressKeyHelper(String key){
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(key)));
    }

    public static void userShouldSeeHelper(String element){
        boolean displayed = locateElements(element).isDisplayed();
        Assert.assertEquals(true,displayed);
    }

    public static void mobileTextInShouldBeHelper(String element,String result){
        String expected = locateElements(element).getText();
        Assert.assertEquals(expected,result);
    }

    public static void navigateHelper(String url){
        driver.navigate().to(url);
    }

    public static void enterToAreaHelper(String input,String element){

        locateElements(element).sendKeys(input+ Keys.ENTER);
    }

    public static void clickHelper(String element){
        locateElements(element).click();
    }

    public static void shouldSeePageHelper(String element){
        boolean displayed = locateElements(element).isDisplayed();
        Assert.assertEquals(true,displayed);
    }

    public static void userViewsHelper(String element) {
        boolean displayed = locateElements(element).isDisplayed();
        Assert.assertEquals(true, displayed);
    }

    public static void moveToHelper(String element, String element2){
        WebElement element3 = locateElements(element2);
        WebElement element1 = locateElements(element);
        Actions action = new Actions(driver);

        action.moveToElement(element1).click().moveToElement(element3).build().perform();
    }

}
