$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\login.feature");
formatter.feature({
  "name": "Logging in to the system",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User log in a created account Then add product to wishlist",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@user_shopping_with_log_in"
    }
  ]
});
formatter.step({
  "name": "log in with user \"GetirUser\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.loginWithEmail(String)"
});
formatter.result({
  "status": "passed"
});
});