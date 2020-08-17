Feature: Order Form Functionality



  Scenario Outline: Ordering different item

    Given Navigate to smartbearsoftware
    When Enter the username and password and click on login button
    Then Navigate to Order page
    Then Miss each part one by one (Customer Name, Street, City, State, Zip, Card NUmber, and Exp Date)
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
    Then Verify the Error Message
      |warning | <Warning> |
    When Navigate to view all orders page
    Then Verify Number Of Items On the Order List

    Examples:

      |Name   |  Quantity |  Street | City      |  State |  Zip  | Card Number | Expire Date| Options      | Warning |
      |       |    1      |  Bernard| Pittsburgh|  NJ    |  15234| 293858590409| 08/23      |  FamilyAlbum |  2      |
      |Yakup  |    1      |         | Pittsburgh|  NJ    |  15234| 293858590409| 08/23      |  ScreenSaver |  3      |
      |Yakup  |    1      |Bernard  |           |  NJ    |  15234| 293858590409| 08/23      |  ScreenSaver |  4      |
      |Yakup  |    1      |Bernard  | Pittsburgh|  NJ    |       | 293858590409| 08/23      |  ScreenSaver |  5      |
      |Yakup  |    1      |Bernard  | Pittsburgh|  NJ    |  15234|             | 08/23      |  ScreenSaver |  6      |
      |Yakup  |    1      |Bernard  | Pittsburgh|  NJ    |  15234| 293858590409|            |  ScreenSaver |  7      |

    Scenario: Invalid input

      Given Navigate to smartbearsoftware
      When Enter the username and password and click on login button
      Then Navigate to Order page
      Then Input invalid zipcode, date, card Number and verify warning message
      Then Clik on process Button
      Then Verify error message for card type and quantity
      When Navigate to view all orders page
      Then Verify Number Of Items On the Order List



