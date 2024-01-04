Feature: End to End Scenario for placing orders
 
  
  Scenario: Verify the user is able to place order
    Given User login to the website
    When User added product to the cart
    Then User place order
    Then User is in place order Page
    When User enter personal titles
    And User clicks purchase
    Then User should see the Thank you for your purchase!
    
  
