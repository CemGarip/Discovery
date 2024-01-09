Feature:Shopping cart actions

  @user_checks_shopping_cart_page_fields
  Scenario: User navigates shopping cart page then checks buttons,coupons and prices
    Given log in with user "GetirUser"
    Given user hovers "Desktops" tab and selects "Mac" option
    Then user clicks "Add to Cart" button from button group
    Then user navigates "Shopping Cart" page and selects "-" tab
    Then user checks payment table "Total" field price is "$100.00"
    Then user edits quantity field as "2" and clicks "update button"
    Then user checks payment table "Total" field price is "$200.00"
    Then user edits quantity field as "3" and clicks "update button"
    Then user checks payment table "Total" field price is "$300.00"
    Given user hovers "Desktops" tab and selects "Mac" option
    Then user clicks "Add to Cart" button from button group
    Then user navigates "Shopping Cart" page and selects "-" tab
    Then user clicks "Estimate Shipping & Taxes" button
    Then user fills estimate shipping fields
    Then user checks alert "Success: Your shipping estimate has been applied!" has message
    Then user checks payment table "Total" field price is "$305.00"
    Then user clicks "Use Coupon Code" button
    Then user enters coupon code "1234"
    Then user clicks "Apply Coupon" button
    Then user checks alert "Warning: Coupon is either invalid, expired or reached its usage limit!" has message

    Then user clicks "Use Gift Certificate" button
    Then user enters gift certificate code "41ICG"
    Then user clicks "Apply Gift Certificate" button
    Then user checks alert "Warning: Gift Certificate is either invalid or the balance has been used up!" has message
    Then user navigates "My Account" page and selects "Logout" tab

  @user_checks_list_actions_on_shopping_page
  Scenario: User checks list actions on shopping page
    Given log in with user "GetirUser"
    Given user hovers "Laptops & Notebooks" tab and selects "Show All Laptops & Notebooks" option
    Then user sort by list "Price (Low > High)"
    Then user checks that the order of prices is correct
    Then user clicks "Add to Cart" button from button group
    Then user clicks "Add to Cart" button
    Then user navigates "Shopping Cart" page and selects "-" tab
    Then user checks payment table "Total" field price is "$122.00"
    Then user clicks "Checkout" button
    Then user navigates "My Account" page and selects "Logout" tab
