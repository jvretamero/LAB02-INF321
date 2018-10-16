package br.unicamp.ecommerce.precoprazo;

import br.unicamp.ecommerce.Configuracao;
import br.unicamp.ecommerce.ServerUtil;
import br.unicamp.ecommerce.model.PrecoPrazo;
import br.unicamp.ecommerce.model.TipoEntregaEnum;
import br.unicamp.ecommerce.service.precoprazo.CalculadoraPrecoPrazo;
import br.unicamp.ecommerce.service.precoprazo.DadosPedido;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CalcularPrecoPrazoTest {

    final int port = 9876;

    boolean servicoIndisponivel = false;

    WireMockServer fakeServer;

    @Mock
    Configuracao configuracao;

    @InjectMocks
    CalculadoraPrecoPrazo calculadora;

    DadosPedido dadosPedido;

    TipoEntregaEnum tipoEntrega;

    PrecoPrazo precoPrazo;

    @Before
    public void setUp() {
        fakeServer = new WireMockServer(port);
        fakeServer.start();

        MockitoAnnotations.initMocks(this);
        when(configuracao.getConsultaPrecoPrazoUrl()).thenReturn("http://localhost:" + port + "/ws");
    }

    @After
    public void tearDown() {
        fakeServer.stop();
    }

    @Quando("^eu informo meu CEP para cálculo$")
    public void eu_informo_meu_CEP_para_cálculo() throws Throwable {
        fakeServer.stubFor(ServerUtil.getXml("CalcPrecoPrazo", ""));

        precoPrazo = calculadora.obterPrecoPrazo(dadosPedido, tipoEntrega);
    }

    @Então("^o preço e prazo devem ser:$")
    public void o_preço_e_prazo_devem_ser(Map<String, String> tabela) throws Throwable {
        String valorFrete = tabela.get("Valor");
        String prazo = tabela.get("Prazo");

        assertThat(precoPrazo).isNotNull();
        assertThat(precoPrazo.getPrazoEntrega()).isEqualTo(Integer.valueOf(prazo));
        assertThat(precoPrazo.getValorFrete()).isEqualTo(Double.valueOf(valorFrete));
    }

    @Então("^devo receber a mensagem:$")
    public void devo_receber_a_mensagem(String mensagem) throws Throwable {
        assertThat(precoPrazo).isNotNull();
        assertThat(precoPrazo.hasError()).isTrue();
        assertThat(precoPrazo.getMsgErro()).isEqualTo(mensagem);
    }

    @Dado("^eu vou calcular o preço e prazo do meu pedido$")
    public void eu_vou_calcular_o_preço_e_prazo_do_meu_pedido() throws Throwable {
        dadosPedido = null;
        tipoEntrega = TipoEntregaEnum.PACVAREJO;
    }

    @Dado("^o serviço está indisponível$")
    public void o_serviço_está_indisponível() throws Throwable {
        servicoIndisponivel = true;
    }
}
