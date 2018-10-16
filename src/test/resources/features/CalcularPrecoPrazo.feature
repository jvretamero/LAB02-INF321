# language: pt
Funcionalidade: Cálculo de preço e prazo

    Contexto:
        Dado eu vou calcular o preço e prazo do meu pedido

    Cenário: Consultar preço e prazo com dados válidos
        Quando eu informo meu CEP para cálculo
        Então o preço e prazo devem ser:
            | Preço | 100 |
            | Prazo | 2   |

    Cenário: Consultar preço e prazo com dados inválidos
        E os dados estão inválidos
        Quando eu informo meu CEP para cálculo
        Então devo receber a mensagem:
        """
        Dados inválidos, tente novamente
        """

     Cenário: Indisponibilidade no serviço
        E o serviço está indisponível
        Quando eu informo meu CEP para cálculo
        Então devo receber a mensagem:
        """
        Serviço indisponivel
        """