package br.unicamp.ecommerce.OrderStatus;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.unicamp.ecommerce.model.*;
import br.unicamp.ecommerce.service.CorreioService;
import br.unicamp.exemplo.Calculadora;
import br.unicamp.exemplo.dao.CalculadoraDAO;

import org.mockito.Mockito;

import br.unicamp.ecommerce.dao.*;

public class OrderStatusSteps {

    private EncomendaDao encomendaDAO;

    private Encomenda encomenda = new Encomenda();

    private CorreioService service = new CorreioService();

    @Before
    public void setUp() {
        encomendaDAO = Mockito.mock(EncomendaDao.class);
    }

    @Given("^I have a Encomenda (\\d+)$")
    public void i_have_a_Encomenda(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        encomenda = encomendaDAO.getEncomendaById(arg1);
    }

    @When("^I choose to check Encomenda (\\d+) StatusEncomenda$")
    public void i_choose_to_check_Encomenda_StatusEncomenda(int arg1) throws Throwable {
        this.encomenda = new Encomenda();
        this.encomenda.setStatusEncomenda(service.getStatusEncomenda(arg1));
    }

    @Then("^show the details screen$")
    public Encomenda show_the_details_screen() throws Throwable {
        return this.encomenda;
    }


}
