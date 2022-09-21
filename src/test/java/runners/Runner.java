package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@customer_login1",
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