package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/html-reports/cucumber.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "./src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
        tags = "@failed_scenario or @google_search",
        dryRun = false
)
public class Runner {
}
/*
Runner class is user to run teh test cases
Runner connects feature files and step definitions
feature : path of the features folder
glue    : path of the step definitions
 */
/*
There is a user story: US145324 User should be able to make a payment with PayPal
Developer : Ahmet
Tester : Arslan
 Sprint starter on a Thursday
Ahmet starts developing the story in the dev environment
Arslan start creating test cases, positive, negative, edge cases,…
Tuesday Ahmet did some unit testing then deployed the code in the test environment and changed the story “Ready for Testing” in JIRA. Also in DSU Ahmet gave update to the team : I completed one of my user story. US145324 is ready for testing
Arslan : I will start testing the US145324 today.
On Tuesday, Arslan :
Manual Tests -> 1. All is WELL -> Then Complete your automation script -> Run your script -> All is well then attached the automation report to the JIRA. And Change the JIRA status “Ready For Acceptance”. Make sure to attach any new element screenshot as a proof. For example, Take a screenshot of PayPal option and attach to JIRA. We can attach multiple document to JIRA
Manual Tests-> 2. Failed Test Case(Example, PayPal option is created, but user can not select that option). -> Since sprint is still going on, Arslan talk to Ahmet and says the problem. Ahmet checked the functionality, fixes the issue in the Dev, do unit testing, then deploy the code again.
NOTE: If the functionality doesn’t work as expected after the sprint over, then we should raise a bug.
ALL THESE DEPENDS ON THE COMPONY AGILE IMPLEMENTATION
 */