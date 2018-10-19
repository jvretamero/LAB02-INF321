package br.unicamp.ecommerce.orderstatus;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        glue = "br.unicamp.ecommerce.orderstatus",
        features = "classpath:features/StatusEntrega.feature"
)
public class RunStatusEntregaTest {

}
