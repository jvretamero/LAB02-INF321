package br.unicamp.ecommerce.service;

import br.unicamp.ecommerce.Configuracao;
import br.unicamp.ecommerce.model.Endereco;

public class BuscaEnderecoService {

  private Configuracao configuracao;

  public Endereco buscar(String cep) throws Exception {
    String url = String.format("%s/%s/xml", configuracao.getBuscarEnderecoUrl(), cep);
    return new RemoteService().getAndParseXml(url, Endereco.class);
  }

}
