package br.unicamp.ecommerce.service.precoprazo;

import br.unicamp.ecommerce.Configuracao;
import br.unicamp.ecommerce.dao.DadosDeEntregaDAO;
import br.unicamp.ecommerce.model.PrecoPrazo;
import br.unicamp.ecommerce.model.TipoEntregaEnum;

public class CalculadoraPrecoPrazo {

    private Configuracao configuracao;
    private DadosDeEntregaDAO entregaDao;

    public PrecoPrazo obterPrecoPrazo(DadosPedido dadosPedido, TipoEntregaEnum tipoEntrega) {
        return null;
    }
}
