package com.example.StepDefinitions;

import com.example.PageClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefs extends BaseClass {

    @Before
    public void setup(){
        setDriver();
    }

    @After
    public void teardown(){
        closeDriver();
    }

    @Then("I go to OrangeHRM Home page.")
    public void iGoToOrangeHomePage() {
        try {
            loginPage.getOrangeHRMHome();
        } catch (Exception e) {
            System.out.println("Username not sent.");
        }
    }

    @When("I enter {string} username and {string} password.")
    public void iEnterUsernameAndPassword(String arg0, String arg1) {
        try {
            loginPage.systemLogin(arg0,arg1);
        } catch (Exception e) {
            System.out.println("Username not sent.");
        }
    }

    @When("I enter username and password.")
    public void iEnterUsernameAndPassword() {
        try {
            loginPage.systemLogin("Admin","admin123");
        } catch (Exception e) {
            System.out.println("Username not sent.");
        }
    }

    @And("I navigate to PIM tab and click on add employee.")
    public void iNavigateToPIMTabAndClickOnAddEmployee() {
        try {
            loginPage.clickOnPIM().clickOnAddEmployee();
        } catch (Exception e) {
            System.out.println("Username not navigate to add employee tab.");
        }
    }

    @And("I enter employee details and save it.")
    public void iEnterEmployeeDetailsAndSaveIt() {
        try {
            loginPage.enterFirstNameAndLastName().fileUpload().checkBoxCreateLoginDetail().enterLoginDetail().verifySuccessMessage().verifySuccessMessageForAdd();
        } catch (Exception e) {
            System.out.println("Username not navigate to add employee tab.");
        }
    }
}
