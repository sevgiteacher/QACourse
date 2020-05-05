package selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static selenium.LocatorMethods.*;

public class SeleniumHelper {

    public static void userShouldSeeHelper(String element){
        boolean displayed = locateElements(element).isDisplayed();
        Assert.assertEquals(true,displayed);
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
