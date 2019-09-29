package scenarios;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by alexandra.nagy
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/scenarios"},
        tags = {"@DSLCalculator"})
public class ExecuteTests {
}
