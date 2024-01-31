Feature: Place order on DemoBlaze site

  Scenario Outline: Place an order to buy a laptop using Credit Card
    Given I want to place an order to buy a laptop in <site>
    When I look my laptop <laptop> in Laptops section
    And I fill the user details <Name> <Country> <City> <CreditCard> <Month> <Year>
    Then I verify the <ExpectedResult> <Name> of my order

    Examples: 
      | site  | laptop | Name | Country | City | CreditCard | Month | Year | ExpectedResult |
      | "https://demoblaze.com/" | "MacBook Pro" | "John Doe" | "Portugal" | "Lisbon" | "375567668884617" | "02" | "2030" | "Thank you for your purchase!" |
      | "https://demoblaze.com/" | "MacBook Pro" | "Percy Clayton" | "United States" | "Jacksonville" | "4411732769254916" | "4" | "2029" | "Thank you for your purchase!" |


  Scenario Outline: Place an order to buy a laptop without Credit Card details
    Given I want to place an order to buy a laptop in <site>
    When I look my laptop <laptop> in Laptops section
    And I fill incomplete user details <Name> <Country> <City>
    Then I verify that error message <Error Message> is displayed

    Examples:
      | site  | laptop | Name | Country | City | Error Message |
      | "https://demoblaze.com/" | "MacBook Pro" | "John Doe" | "Portugal" | "Lisbon" | "Please fill out Name and Creditcard." |


