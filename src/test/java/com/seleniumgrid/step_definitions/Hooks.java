package com.seleniumgrid.step_definitions;

import com.seleniumgrid.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In the class we will be able to pass pre- & post- conditions to
each scenario and each step
 */
public class Hooks {

    /*@Before(value = "@none",order = 1)// import from io.cucumber.java not from junit
    public void setupScenario(){
        System.out.println("====Setting up browser using in cucumber @Before");
    }
    @Before (value = "@login",order = 2) // this method is applied for only scenarios with @login tag
    public void setupScenarioForLogins(){
        System.out.println("====this will only apply to scenarios with @login tag");
    }

    @Before (value = "@db",order = 0) // this method is applied for only scenarios with @login tag
    public void setupForDatabaseScenarios(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }*/

    @After
    public void tearDownScenario(Scenario scenario){
        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }


        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
    }

    @BeforeStep(value = "@step")
    public void setupStep(){
        System.out.println("------> applying setup using @BeforeStep");
    }

    @AfterStep(value = "@step")
    public void afterStep(){
        System.out.println("------> applying teardown using @AfterStep");
    }


}
