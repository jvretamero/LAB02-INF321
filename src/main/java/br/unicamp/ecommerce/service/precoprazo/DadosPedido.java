package br.unicamp.ecommerce.service.precoprazo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CalcPrecoPrazo")
public class DadosPedido {

    public String cep;

    public float peso;

    public float comprimento;

    public float altura;

    public float largura;

    public float diametro;
}
