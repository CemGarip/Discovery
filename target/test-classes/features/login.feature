Feature:Logging in to the system

  @user_shopping_with_log_in
  Scenario: User log in a created account Then add product to wishlist
    Given log in with user "GetirUser"
    Then user hovers "Components" tab and selects "Monitors" option
    Then user clicks "Samsung SyncMaster 941BW" product
    Then user clicks "Add to Wish List" button from button group
    Then user checks alert "Success: You have added Samsung SyncMaster 941BW to your wish list!" has message
    Then user navigates "Wishlist" page and selects "-" tab
    Then user clicks "Remove" button
    Then user checks alert "Success: You have removed an item from your wishlist" has message
    Then user hovers "Components" tab and selects "Monitors" option
    Then user clicks "Samsung SyncMaster 941BW" product
    Then user clicks "Add to Wish List" button from button group
    Then user navigates "Wishlist" page and selects "-" tab
    Then user navigates "My Account" page and selects "Logout" tab

  @user_shopping_without_log_in
  Scenario: User log in without any account First user buy some product then register an account and check order history
    Given user hovers "Desktops" tab and selects "Mac" option
    Then user checks header cart "empty"
    Then user clicks "Add to Cart" button from button group
    Then user checks alert "Success: You have added iMac to your shopping cart!" has message
    Then user checks header cart "has iMac"
    Then user navigates "Checkout" page and selects "-" tab
    Then user fills payment address
    Then user fills logIn credentials with Register Account option
    Then user clicks "Continue" button
    Then user selects shipping and payment method
    Then user checks payment table "Sub-Total" field price is "$100.00"
    Then user checks payment table "Total" field price is "$127.00"
    Then user clicks "Confirm Order" button
    Then user checks bread crumbing trail is "Success"
    Then user navigates "My Account" page and selects "Order History" tab
    Then user returns product with filling product return form
    Then user clicks "Continue" button
    Then user navigates "My Account" page and selects "Logout" tab

  @user_log_in_with_invalid_user
  Scenario: User tries to login with invalid user and checks alert messages
    Then user navigates "My Account" page and selects "Login" tab
    Then user tries to login with invalid user
    Then user checks alert "Warning: No match for E-Mail Address and/or Password." has message
    Then user clicks forgotten password and try to change password with invalid email
    Then user checks alert "Warning: The E-Mail Address was not found in our records!" has message

  @user_register_new_account_check_warnings
  Scenario: User register new account and checks blank field errors and alert messages
    Then user navigates "My Account" page and selects "Register" tab
    Then user checks blank field errors
    Then user fills register account fields
    Then user navigates "My Account" page and selects "Logout" tab










