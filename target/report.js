$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feature/AdactinLogin.feature");
formatter.feature({
  "name": "Validating the login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "verifying the login functionalty with valid username and password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user launches GC browser and enters adactin login page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.userLaunchesGCBrowserAndEntersAdactinLoginPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter the user name \u00276383184289\u0027  and password \u0027Cricket@07\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.user_enter_the_user_name_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks in login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.userClicksInLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validating user enters into search hotel page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.validatingUserEntersIntoSearchHotelPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user print title of the search page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.userPrintTitleOfTheSearchPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});