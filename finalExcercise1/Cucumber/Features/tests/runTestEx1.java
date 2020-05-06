package finalExcercise1.Cucumber.Features.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/finalExcercise1/Cucumber/Features",
        glue = {"finalExcercise1.Cucumber.Features.steps"},
        plugin = {"pretty", "html:out"}
        )


public class runTestEx1 {
}
