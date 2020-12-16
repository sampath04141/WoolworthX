package woolworth;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsonOutput/cucumber.json", "html:target/report.html"},
        features = {"src/test/java/woolworth/features"}
       // tags = {"@xx"}
)
public class TestRunner {
}
