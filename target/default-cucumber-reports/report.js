$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\login.feature");
formatter.feature({
  "name": "Logging in to the system",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User register new account and checks blank field errors and alert messages",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@user_register_new_account_check_warnings"
    }
  ]
});
formatter.step({
  "name": "user navigates \"My Account\" page and selects \"Register\" tab",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefs.userNavigatesPage(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user checks blank field errors",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.userChecksBlankFieldErrors()"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[First Name must be between 1 and 32 characters!]\u003e but was:\u003c[]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat org.junit.Assert.assertEquals(Assert.java:146)\r\n\tat com.getir.pages.LoginPage.checksBlankFieldErrors(LoginPage.java:91)\r\n\tat com.getir.stepdefs.LoginStepDefs.userChecksBlankFieldErrors(LoginStepDefs.java:34)\r\n\tat ✽.user checks blank field errors(src\\test\\resources\\features\\login.feature:51)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user fills register account fields",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.userFillsRegisterAccountFields()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user navigates \"My Account\" page and selects \"Logout\" tab",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefs.userNavigatesPage(String,String)"
});
formatter.result({
  "status": "skipped"
});
});