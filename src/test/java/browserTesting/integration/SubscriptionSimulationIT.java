package browserTesting.integration;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"browserTesting"},
        tags = "@SubscriptionSimulation"
)
public class SubscriptionSimulationIT {
}
