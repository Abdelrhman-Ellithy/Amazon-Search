package Base;

import Ellithium.DriverSetup.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseStepDefinitions {
    protected WebDriver driver;
    public BaseStepDefinitions(){
        this.driver= DriverFactory.getNewDriver();
    }
}
