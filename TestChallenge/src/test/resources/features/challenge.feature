Feature: Completting challenge 

  
    
    Scenario: Check validity of CNP
    Given user is on the challenge page
    
    When user enters 190042401001
    And clicks on checkValidity button
    Then user enters 197072707005
    And clicks on checkValidity button
    Then user enters 296062306004
    And clicks on checkValidity button
    Then user enters 195042102003
    And clicks on checkValidity button
    Then user enters 290041404002
    And clicks on checkValidity button
    Then close browser
    
   
 
    
