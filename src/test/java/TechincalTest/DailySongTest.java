package TechincalTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/html"},features = {"classpath:features/video.feature"},tags= {"@important"})
public class DailySongTest {

}
