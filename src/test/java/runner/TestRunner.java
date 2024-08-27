package runner;

import tests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="/Users/lillys/Desktop/Lilly/Java workspace/NopCommerce/src/test/java/features"
,glue= {"steps"}
,plugin= {"pretty","html:target/cucumber-html.report"})  // pretty means rich html
public class TestRunner extends TestBase {

}