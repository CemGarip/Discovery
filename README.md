
# Getir Project
The tests are run on the basis of cucumber from the page named "LocalRunner".
Scenarios are written in "feature" files with a user-friendly structure.
You can find the CI/CD at https://github.com/CemGarip/GetirProject/actions tab.
If you click on some of the studies, you can also find the test report bottom of the page.
The following were used in this project.
- Java
- JUnit
- Selenium
- Cucumber
- Faker

Requirements to be installed on the system to run the project:
- Java
- Maven
- Cucumber(add with plugin)

## Contents
### Pages.package
In this package, the pages are separated according to the fields they are related to.
- CheckoutPage
- HeaderPage
- LoginPage
- ShoppingPage
- WishListPage

### Runner.package
In this package,We have local runner the written with "Cucumber" based and this reason we can run test scenarios according to name tags.
- LocalRunner

### StepDefs.package
The step definitions are divided according to the fields they are related to. We can run test cases by linking pages and features.
- CheckoutStepDefs
- CommonStepDefs
- LoginStepDefs
- ShoppingStepDefs
- WishListStepDefs

### Utils.package
This package contains pages such as HtmlManipulator, WaitUtils, BasePage for frequently used functions in test cases. 
Pages such as Driver, Hook, Resources are the pages that support the system in starting and running.
- HtmlManipulator (frequently used methods)
- User (Json.credentials reader)
- BasePage (frequently used methods)
- ConfigurationReader (configuration.properties reader)
- Driver (Web browser settings)
- Hook (@Before @After executing the scenario)
- Resources (JsonObject resources )
- TestConfiguration (Configuring chrome options)
- WaitUtils (frequently used wait methods)


### Pages (introducing pages to the system)

### Features
Features include a list of scenarios.the features are separated according to the fields they are related to.
- login.feature
- shoppingCart.feature
- wishlist.feature

### test_data 
- credentials.json

### configuration.properties

### pom.xml

## Scenarios
### login.feature
- In this feature, it is aimed to test what actions the user can do by logging in or not and what warnings user receives. 
Because the steps that a registered user and an unregistered user may encounter in shopping sites are different.
### shoppingCart.feature
- On this page, the user is now at the purchasing stage. 
The parts that the user will consider here are parts such as payment, shipping, coupon information. How the user experiences these parts has been tested.
### wishlist.feature
- On this page, the parts that the user will see in the wishlist when she/he wants to compare the products likes have been tested.
