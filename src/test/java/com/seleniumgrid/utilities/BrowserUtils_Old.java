package com.seleniumgrid.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils_Old {

    public static void sleep(int second){

        /*
        This method will accepet int (in seconds) and execute Thread.sleep for given duration
         */

        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }
    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl
        - If condition matches, will break loop
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInURl, String expectedInTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);

            System.out.println("CurrentURL = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getTitle().contains(expectedInURl)) {
                break;
            }
        }


        //5. Assert: Title contains “Etsy”
        String actualTitle = Driver.getDriver().getTitle();


        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        //Lines to be pasted:

        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.

    }

    /*
    This method accepts a String "expectedTitle" and Assert if it is true
     */
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /*Creating a utility method for ExplicitWait, so we don't have to repeat the lines*/
    public static void waitForVisibilityOf(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * This method will accept a String as expected valuue actual URL CONTAINS the value.
     * @param expectedInUrl
     */
    public static void verifyURLContains(String expectedInUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all of the options' text in a List of String.
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**
     * This method will accept a group of radio buttons as List of WebElement.
     * It will loop through the list,
     * and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }

}
