# language: pt
Funcionalidade: OrderStatus
    Como usuário
    Eu quero consultar o status de entrega dos meus pedidos
    Para que eu saiba quando será entregue

    Cenário: Consultar status da encomenda
        Dado eu tenho um código de rastreamento
        Quando consulto o status da entrega
        Então devo receber o evento dos Correios
    
  