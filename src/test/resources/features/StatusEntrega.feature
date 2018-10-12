Feature: OrderStatus
  As a user
  I want to check the delivery status from my orders
  So I can view the order details

  Scenario: Check order status
    Given I have a Encomenda 2
    When I choose to check Encomenda 3 StatusEncomenda
    Then show the details screen
    
  