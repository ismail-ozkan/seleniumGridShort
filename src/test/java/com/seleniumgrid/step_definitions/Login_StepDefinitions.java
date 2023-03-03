package com.seleniumgrid.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {

    @Given("user in on the library login page")
    public void user_in_on_the_library_login_page() {
        System.out.println("user in on the library login page");
    }

    @When("User enter librarian username")
    public void user_enter_librarian_username() {
        System.out.println("User enter librarian username");
    }

    @When("User enter librarian password")
    public void user_enter_librarian_password() {
        System.out.println("User enter librarian password");
    }

    @Then("User should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User should see the dashboard");
    }

    @When("user enters librarian username")
    public void userEntersLibrarianUsername() {
        System.out.println("user enters librarian username");
    }

    @And("user enters librarian password")
    public void userEntersLibrarianPassword() {
        System.out.println("user enters librarian password");
    }

    @Then("user should see the dashboard")
    public void userShouldSeeTheDashboard() {
        System.out.println("user should see the dashboard");
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        System.out.println("user enters student username");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        System.out.println("user enters student password");
    }

    @When("user enter admin username")
    public void userEnterAdminUsername() {
        System.out.println("user enter admin username");
    }

    @And("user enter admin password")
    public void userEnterAdminPassword() {
        System.out.println("user enter admin password");
    }
}
