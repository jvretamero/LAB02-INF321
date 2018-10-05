# language: pt
Funcionalidade: Cálculo de preço e prazo

    Cenário: Consultar preço e prazo com dados válidos
        Dado vou calcular o preço e prazo do meu pedido
        Quando eu informo meu CEP para cálculo
        Então o preço e prazo devem ser:
            | Preço | 100 |
            | Prazo | 2   |

    Cenário: Consultar preço e prazo com CEP inválido
        Dado vou calcular o preço e prazo do meu pedido
        Quando eu informo um CEP inválido
        Então devo receber a mensagem:
        """
        CEP inválido
        """