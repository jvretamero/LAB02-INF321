package br.unicamp.ecommerce.service.precoprazo;

import br.unicamp.ecommerce.Configuracao;
import br.unicamp.ecommerce.model.PrecoPrazo;
import br.unicamp.ecommerce.model.TipoEntregaEnum;
import br.unicamp.ecommerce.service.RemoteService;

public class CalculadoraPrecoPrazo {

    private Configuracao configuracao;

    public PrecoPrazo obterPrecoPrazo(DadosPedido dadosPedido, TipoEntregaEnum tipoEntrega) throws Exception {
        String url = String.format("%s/%s/xml", configuracao.getConsultaPrecoPrazoUrl(), "CalcPrecoPrazo");
        return new RemoteService().postAndParseXml(url, PrecoPrazo.class, dadosPedido, DadosPedido.class);
    }
}