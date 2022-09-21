package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CustomerLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CustomerLoginStepDefs {
    CustomerLoginPage customerloginPage = new CustomerLoginPage();

    @Given("user enters to application url")
    public void user_enters_to_application_url() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

    }

    @When("user is on the application website")
    public void user_is_on_the_application_website() {
        Assert.assertTrue(Driver.getDriver().getTitle().startsWith("Blue"));

    }

    @Then("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        ReusableMethods.waitForVisibility(customerloginPage.loginButton, 5);
     customerloginPage.loginButton.click();
    }

    @Then("user enters customer_username")
    public void user_enters_customer_username() {

        customerloginPage.customer_email.sendKeys(ConfigReader.getProperty("customer_username")+Keys.ENTER);
    }

    @Then("user enters customer_password")
    public void user_enters_customer_password() {

        customerloginPage.customer_pwd.sendKeys(ConfigReader.getProperty("customer_password")+Keys.ENTER);
    }

    @Then("user clicks on Login Button")
    public void user_clicks_on_login_button() {

        ReusableMethods.waitForClickablility(customerloginPage.submitButton, 5);
        customerloginPage.submitButton.click();
    }

    @Then("verify user is logged in")
    public void verify_user_is_logged_in() {

        ReusableMethods.waitForVisibility(customerloginPage.continueReservationText, 5);
        Assert.assertTrue(customerloginPage.continueReservationText.isDisplayed());
    }
}