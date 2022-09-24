package stepdefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import java.util.List;
import java.util.Map;
public class AppLoginStepDefs {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @When("user navigate the login page")
    public void user_navigate_the_login_page() {
//        homePage.homeLoginButton.click();
//        OR CALL THE READY METHOD THAT CLICK ON THE LOGIN LINK
        homePage.clickOnLoginLink();
    }
    @When("user enters username as {string} and password as {string} and click on login button")
    public void user_enters_username_as_and_password_as_and_click_on_login_button(String username, String password) {
//        sending username
        loginPage.username.sendKeys(username);
//        sending password
        loginPage.password.sendKeys(password);
//        clicking on login button
        loginPage.loginButton.click();
    }
    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
//      if userID is displayed, then login is successful
        Assert.assertTrue(homePage.userID.isDisplayed());
    }
    @When("user enters manager_username and manager_password")
    public void user_enters_manager_username_and_manager_password(DataTable credentials) {
////        1. get the feature file data as LIST
//        List<String> customerData = credentials.row(1);//row number starts at 0. our data is in row 1
////        System.out.println(customerData.get(0));//customer@bluerentalcars.com
////        System.out.println(customerData.get(1));//12345
//        loginPage.username.sendKeys(customerData.get(0));
//        loginPage.password.sendKeys(customerData.get(1));
//        loginPage.loginButton.click();

//        2. get the feature file data as List<Map<String,String>>
        List<Map<String,String>> customerCredentials = credentials.asMaps(String.class,String.class);

        for (Map<String,String> each : customerCredentials){
            loginPage.username.sendKeys(each.get("username"));
            loginPage.password.sendKeys(each.get("password"));
            loginPage.loginButton.click();


        }


    }
}