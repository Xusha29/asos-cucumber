Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks bag icon visibility
    And User checks saved items icon visibility
    And User checks my account icon visibility
    When User clicks My Account Icon
    And User checks sign in icon visibility
    And User checks join icon visibility
    And User clicks Sign In Icon
    Then User checks Join tab visibility
    And User checks email field visibility on sign in
    And User checks password field visibility on sign in
    And User checks SSO authentication links visibility

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check view an added product and checkout in bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Add to bag' button on product
    And User checks that add to bag popup visible
    And User checks 'View bag' button visibility
    Then User checks add to bag popup title is '<title>'
    And User clicks 'View bag' button
    And User clicks 'Checkout' button in bag
    And User clicks 'Join' tab
    And User clicks 'Continue to checkout' button

    Examples:
      | homePage              | keyword  | title  |
      | https://www.asos.com/ | 23846304 | 1 item |

  Scenario Outline: Check add product to saved items
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Save for later' on first product
    And User clicks 'Saved Items' button
    Then User checks that amount of products in saved items are '<amountOfItems>'
    And User checks that amount of buttons is <amountOfButtons>

    Examples:
      | homePage              | keyword | amountOfItems | amountOfButtons |
      | https://www.asos.com/ | face    | 3 items       | 3               |

  Scenario Outline: Check add 2 items of product to bag with quick checkout
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Add to bag' button on product
    And User checks that add to bag popup visible
    And User checks 'Checkout' button visibility
    And User clicks 'Add to bag' button on product second time
    Then User checks add to bag popup title is '<title>'
    And User clicks 'Checkout' button
    And User clicks 'Join' tab
    And User clicks 'Continue to checkout' button

    Examples:
      | homePage              | keyword  | title   |
      | https://www.asos.com/ | 23846304 | 2 items |

  Scenario Outline: Check wrong url for page
    Given User opens '<homePage>' page
    When User enters '<wrongPage>' page
    Then User checks message wrong page: <messageWrongPage>

    Examples:
      | homePage              | wrongPage                              | messageWrongPage               |
      | https://www.asos.com/ | https://www.asos.com/women/absent-page | Sorry, we can't find that page |

  Scenario Outline: Check notification for Sign In with a wrong e-mail
    Given User opens '<homePage>' page
    And User clicks My Account Icon
    And User clicks Sign In Icon
    When User enters '<wrongEmailFormat>' to email address field
    Then User checks that there is wrong email notification: '<notification>'

    Examples:
      | homePage              | wrongEmailFormat | notification |
      | https://www.asos.com/ | test             | Email fail!  |

  Scenario Outline: Check notification for Sign In with a blank password
    Given User opens '<homePage>' page
    And User clicks My Account Icon
    And User clicks Sign In Icon
    When User enters blank text to password field
    Then User checks that there is empty password notification: '<notification>'

    Examples:
      | homePage              | notification                 |
      | https://www.asos.com/ | Hey, we need a password here |
