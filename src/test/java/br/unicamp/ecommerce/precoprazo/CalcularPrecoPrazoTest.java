package br.unicamp.ecommerce.precoprazo;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CalcularPrecoPrazoTest {

    @Dado("^vou calcular o preço e prazo do meu pedido$")
    public void vou_calcular_o_preço_e_prazo_do_meu_pedido() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Quando("^eu informo meu CEP para cálculo$")
    public void eu_informo_meu_CEP_para_cálculo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^o preço e prazo devem ser:$")
    public void o_preço_e_prazo_devem_ser(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @Quando("^eu informo um CEP inválido$")
    public void eu_informo_um_CEP_inválido() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^devo receber a mensagem:$")
    public void devo_receber_a_mensagem(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
