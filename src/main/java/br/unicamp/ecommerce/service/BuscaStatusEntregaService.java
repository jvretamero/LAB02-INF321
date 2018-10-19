package br.unicamp.ecommerce.service;

import br.unicamp.ecommerce.Configuracao;
import br.unicamp.ecommerce.model.Endereco;
import br.unicamp.ecommerce.model.StatusEncomenda;

public class BuscaStatusEntregaService {

    private Configuracao configuracao;

    public StatusEncomenda getStatusEncomenda(String codigoRastreamento) throws Exception {
        String url = configuracao.getStatusEntregaUrl();
        return new RemoteService().getAndParseXml(url, StatusEncomenda.class);
    }

}
