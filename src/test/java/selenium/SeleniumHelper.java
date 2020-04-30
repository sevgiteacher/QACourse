package selenium;



import static selenium.LocatorMethods.*;

public class SeleniumHelper {


    public static void navigateHelper(String url){
        driver.navigate().to(url);
    }

    public static void enterToAreaHelper(String input,String area){
        locateElements(area).sendKeys(input);
    }


}
