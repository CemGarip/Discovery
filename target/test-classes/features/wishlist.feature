Feature:Wishlist actions
  @user_checks_wishlist_page_fields
  Scenario: User navigates wishlist page then checks table values and buttons
    Given log in with user "GetirUser"
    Then user hovers "Desktops" tab and selects "Mac" option
    And user clicks "Add to Wish List" button from button group
    Then user hovers "Desktops" tab and selects "Show All Desktops" option
    And user clicks "HTC Touch HD" product
    And user clicks "Add to Wish List" button
    Then user navigates "Wish List" page and selects "-" tab
    Then user checks "HTC Touch HD" is "exist"
    Then user clicks "Add to Cart" button
    Then user navigates "Shopping Cart" page and selects "-" tab
    Then user checks "HTC Touch HD" is "exist"

    Then user hovers "Desktops" tab and selects "Show All Desktops" option
    And user clicks "HP LP3065" product
    And user clicks "Add to Wish List" button
    Then user hovers "Desktops" tab and selects "Show All Desktops" option
    And user clicks "iPhone" product
    And user clicks "Add to Wish List" button
    Then user hovers "Desktops" tab and selects "Show All Desktops" option
    And user clicks "MacBook Air" product
    And user clicks "Add to Wish List" button

    Then user navigates "Wish List" page and selects "-" tab
    Then user checks "HP LP3065" is "exist"
    Then user checks "iPhone" is "exist"
    Then user checks "iPhone14 Pro" is "not exist"

    Then user checks model order is alphabetical in wishlist table
    #Click remove 4 times cause we want to remove all products
    Then user clicks "Remove" button
    Then user clicks "Remove" button
    Then user clicks "Remove" button
    Then user clicks "Remove" button
    Then user checks wishlist is empty
    Then user navigates "My Account" page and selects "Logout" tab

  @user_compares_products_and_adds_gift_cart
  Scenario: User compares products and adds gift cart
    Given log in with user "GetirUser"
    Then user hovers "Desktops" tab and selects "Show All Desktops" option
    Then user clicks "HTC Touch HD" product
    And user clicks "Compare this Product" button from button group
    Then user checks alert "Success: You have added HTC Touch HD to your product comparison!" has message
    Then user hovers "Desktops" tab and selects "Show All Desktops" option
    Then user clicks "iPhone" product
    And user clicks "Compare this Product" button from button group
    Then user clicks on hyperlink text "product comparison" from alert pop up
    Then user chose cheaper product and adds to cart
    Then user clicks on hyperlink text "shoppping cart" from alert pop up
    Then user checks payment table "Total" field price is "$100.00"
    Then user navigates "Gift Certificates" page from bottom of the page
    Then user fills gift certificate purchase fields
    Then user navigates "Shopping Cart" page and selects "-" tab
    Then user checks payment table "Total" field price is "$101.00"
    Then user navigates "My Account" page and selects "Logout" tab
