package br.unicamp.ecommerce.OrderStatus;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        glue = "br.unicamp.OrderStatus",
        features = "classpath:features/StatusEntrega.feature"
//        name = "nome do cenario"
)
public class RunOrderStatus {

}
