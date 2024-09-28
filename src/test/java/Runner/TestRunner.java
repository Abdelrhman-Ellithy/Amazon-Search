package Runner;

import Ellithium.DriverSetup.SETUP;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "stepDefinitions", // path to your stepDefinitions package, note you should use . instead of /
        features="src/test/resources/features" // path to your features folder
)
public class TestRunner extends BDDSetup {
}