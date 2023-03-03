package com.seleniumgrid.step_definitions;

import com.seleniumgrid.pages.GoogleSearchPage;
import com.seleniumgrid.utilities.BrowserUtils_Old;
import com.seleniumgrid.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        /*System.out.println("User is on Google search page");*/
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        /*System.out.println("USer is seeing title of Google");*/
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //Driver.closeDriver();--> it went to @After annotation in Hooks class
    }

    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        //BrowserUtils.verifyTitle("apple - Google'da Ara");
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not as expected",actualTitle,expectedTitle);

        //Driver.closeDriver(); --> it went to @After annotation in Hooks class
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {
        googleSearchPage.searchBox.sendKeys(searchKeyword+Keys.ENTER);
    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String searchKeyword) {
        BrowserUtils_Old.verifyTitle(searchKeyword+" - Google Search");
    }




}
