# Github Pages
  The test execution report is hosted on GitHub Pages through the link:

    https://alexandrepetrassi.github.io/framework-level-challenge/#

  The report generation took place by manually triggering `mvn clean install`
  and committing the result to its proper branch.

# Technical Debts

* browserTesting.Steps
  * Change the hard coded webdriver path
  * Change the hard coded app URL
  
* features.browser.product.SubscriptionSimulation
  * Split request and validation from steps:
    * I validate my response is correct
    * I validate the user was deleted
  * Validation steps are too generic and should not be reused between completely
    different test cases
  * Response body is not validated at scenarios:
    * Add user with job
    * Delete User
  * Step `I post a request with a new register without password` should be split
  since it is setting data and making requests.
  
# Challenge

## Requirements

* Maven
* Java (JDK 8)
* Git

## Browser and Web Services Testing

The objective of this challenge is to implement Cucumber steps to develop automatic
functional tests on both browser and a web service.  
It is also expected that the candidate is able to understand unit testing and develop some
JAVA methods.  
First, perform some exploratory tests in the following
portal: https://qa-automation-challenge.github.io/sandbox/. If there is any defect, make a
document to report it.

#### Instructions:

* Look at the unit tests and develop the necessary code to run them with success.
* Develop four automated tests according to the description in the acceptanceCriteria
  directory
    * The tests have to be in .feature files described in Gherkin language
    * A report must be generated after test execution
* Describe how you executed the automated tests in your local machine
* Feel free to change, remove or add new Cucumber steps according to the best coding
  practices

**Note: The solution should be shared in your own Git repository. Make sure that you keep
the Git commit history clean**