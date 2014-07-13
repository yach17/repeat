package fr.yach17.repeat.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "classpath:features", glue="fr.yach17.repeat.steps")
public class CucumberRunner {
}