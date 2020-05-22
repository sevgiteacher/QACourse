package selenium;



import org.testng.Assert;

import static selenium.LocatorMethods.*;

public class SeleniumHelper {


    public static void navigateHelper(String url){
        driver.navigate().to(url);
    }

    public static void enterToAreaHelper(String input,String area){
        locateElements(area).sendKeys(input);
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

}
