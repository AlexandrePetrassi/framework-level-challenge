package webServiceTesting.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"webServiceTesting"},
        strict = true,
        tags = "@UserCreation"
)
public class UserCreationIT {
}
