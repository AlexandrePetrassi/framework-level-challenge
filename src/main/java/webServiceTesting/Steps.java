package webServiceTesting;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class Steps {

  CreateUser createUser;
  RegisterUser registerUser;
  String name, job;
  String user = "2";
  Response response;

  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    createUser = new CreateUser();
  }

  @When("^I set name \"([^\"]*)\"$")
  public void setName(String name) {
    createUser.setName(name);
    this.name = name;
  }

  @When("^I set job \"([^\"]*)\"$")
  public void setJob(String job) {
    createUser.setJob(job);
    this.job = job;
  }

  @Then("^I validate my response is correct$")
  public void validateMyResponseIsCorrect() {
    createUser.getRequestSpecification()
            .given()
              .body(createUser.buildBody())
              .contentType(ContentType.JSON)
            .when()
              .post()
            .then()
              .statusCode(201);
  }

  @Then("^I validate the user was deleted$")
  public void validateTheUserWasDeleted() {
    createUser.getRequestSpecification()
            .when()
              .delete("/{user}", user)
            .then()
              .statusCode(204);
  }

  @When("^I post a request with a new register without password$")
  public void postRegisterWithoutPassword(DataTable table) {
    Map<String, String> data = table.asMap(String.class, String.class);
    registerUser = new RegisterUser();
    registerUser.setEmail(data.get("email"));
    response = registerUser.getRequestSpecification()
            .given()
              .body(registerUser.buildBodyWithoutPassword())
              .contentType(ContentType.JSON)
            .when()
              .post();
  }
}
