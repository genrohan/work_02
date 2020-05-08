$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/qa/com/feature/Login.feature");
formatter.feature({
  "name": "Login Page of flipkart.com",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verifying login of the user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Positive"
    }
  ]
});
formatter.step({
  "name": "User is on \"https://www.flipkart.com\" HomePage",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User enters details",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User clicks on final Login",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Verify user is logged in",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});