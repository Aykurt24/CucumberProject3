Feature: Order Form Functionality


  @SmokeTest
  Scenario Outline: Ordering different item

    Given Navigate to smartbearsoftware
    When Enter the username and password and click on login button
    Then Navigate to Order page
    Then Fill the Quantity, Customer Name, Street, City, State, Zip, Card NUmber, and Exp Date
    |customerName| <Name>|
    |quantity    | <Quantity>|
    |street      | <Street>  |
    |city        | <City> |
    |state       | <State>|
    |zip         | <Zip>  |
    |cardNumber  | <Card Number>|
    |expireDate  | <Expire Date>|

    Then Choose the product
    |productList|     <Options>|
    Then Choose Type of Card and click on Process Button
    When Navigate to view all orders page
    Then Verify items count are increased

    Examples:

      |Name  |  Quantity |  Street | City      |  State |  Zip  | Card Number | Expire Date| Options      |
      |Dogan  |    2      |  Bernard| Pittsburgh|  NJ    |  15234| 293858590409| 08/23      |  MyMoney     |
      |Ali    |    1      |  Bernard| Pittsburgh|  NJ    |  15234| 293858590409| 08/23      |  FamilyAlbum |
      |Yakup  |    1      |  Bernard| Pittsburgh|  NJ    |  15234| 293858590409| 08/23      |  ScreenSaver |



