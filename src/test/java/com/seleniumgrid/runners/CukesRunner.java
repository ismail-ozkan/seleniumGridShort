package com.seleniumgrid.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
İsmail Ozkan
what does "Cukes Runner" mean ?
"Cukes Runner" is short for "Cucumber Runner,"
which refers to a test runner that is used to execute automated tests written in the Gherkin language.
 Gherkin is a plain-text language that is used to describe the behavior of an application,
 typically for the purpose of testing. Cucumber is a software tool that is used to run automated tests
 written in Gherkin and execute them against the code of an application.
Cucumber provides a framework that allows developers to write human-readable test scenarios in Gherkin
and then map those scenarios to code that performs the actual testing.
 The Cucumber Runner is responsible for executing the tests and reporting on the results.
  This allows teams to write tests that are easy to understand, maintain, and update, while still
  providing a way to validate the behavior of their applications.




 *///Definition of Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/seleniumgrid/step_definitions",
        dryRun = false,
        tags = "",//@Regression and not @student
        publish = true
)
public class CukesRunner {
}
