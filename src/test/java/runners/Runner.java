package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//is used for better readable report/output
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "./src/test/resources/features",//MUST
        glue = "stepdefinitions",//MUST
        tags = "@password_strenght",//OPTIONAL. WITHOUT TAGS, RUNNER RUNS ALL FEATURES
        dryRun = false//OPTIONAL.
        // WITHOUT dryRun(dryRun=false is default,
        // we can not check completion error without seeing the browser
)
public class Runner {
}