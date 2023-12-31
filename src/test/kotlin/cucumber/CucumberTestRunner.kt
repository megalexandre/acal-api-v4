package cucumber

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/features"],
    glue = ["br.com.acalappv4.glue"],
    plugin = ["pretty", "html:target/cucumber-reports"]
)
class CucumberTestRunner