package br.unicamp.ecommerce.orderstatus;

import br.unicamp.ecommerce.Configuracao;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import br.unicamp.ecommerce.model.*;
import br.unicamp.ecommerce.service.BuscaStatusEntregaService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class StatusEntregaTest {

    @Mock
    public Configuracao configuracao;

    @InjectMocks
    public BuscaStatusEntregaService correioService;

    StatusEncomenda statusEncomenda;
    String codigoRastreamento;
    WireMockServer wireMockServer;

    @Before
    public void setUp() {
        wireMockServer = new WireMockServer(9876);
        wireMockServer.start();
        MockitoAnnotations.initMocks(this);
        Mockito.when(configuracao.getStatusEntregaUrl()).thenReturn("http://localhost:9876/");
    }

    @After
    public void teardown() {
        wireMockServer.stop();
    }

    @Dado("^eu tenho um código de rastreamento$")
    public void eu_tenho_um_código_de_rastreamento() throws Throwable {
        codigoRastreamento = "BR123";

        wireMockServer.stubFor(get(urlMatching("/*")).willReturn(aResponse().withStatus(200)
                .withHeader("Content-Type", "text/xml").withBodyFile("resultado-ConsultaStatusEntrega.xml")));
    }

    @Quando("^consulto o status da entrega$")
    public void consulto_o_status_da_entrega() throws Throwable {
        statusEncomenda = correioService.getStatusEncomenda(codigoRastreamento);
    }

    @Então("^devo receber o evento dos Correios$")
    public void devo_receber_o_evento_dos_Correios() throws Throwable {
        assertThat(statusEncomenda).isNotNull();
        assertThat(statusEncomenda.getDescricao()).isEqualTo("Entregue");
    }
}
