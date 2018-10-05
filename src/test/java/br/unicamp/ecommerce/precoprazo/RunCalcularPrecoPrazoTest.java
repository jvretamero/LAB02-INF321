package br.unicamp.ecommerce.precoprazo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        glue = "br.unicamp.ecommerce.precoprazo",
        features = "classpath:features/CalcularPrecoPrazo.feature"
)
public class RunCalcularPrecoPrazoTest {
}
