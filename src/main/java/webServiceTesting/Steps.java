package webServiceTesting;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Steps {

  private static final int REQUEST_CAP = 1000;

  CreateUser createUser;
  RegisterUser registerUser;
  String name, job;
  String user = "2";
  String email;
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
    this.email = data.get("email");
    registerUser.setEmail(email);
    response = registerUser.getRequestSpecification()
            .given()
              .body(registerUser.buildBodyWithoutPassword())
              .contentType(ContentType.JSON)
            .when()
              .post();
  }

  @Then("^I validate the status code is (\\d+)$")
  public void validateTheStatusCodeIs(int statusCode) {
    response.then().statusCode(statusCode);
  }

  @Then("^I validate the register is not created$")
  public void validateRegisterNotCreated() {
    for(int currentPage = 1; currentPage < REQUEST_CAP; ++currentPage) {
      List<String> emails = RestAssured
              .given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .queryParam("page", currentPage)
              .when()
                .get()
              .then()
                .extract()
                .jsonPath()
                .getList("data.email");
      if (emails.isEmpty()) return;
      assertThat(emails, not(hasItem(email)));
    }
  }
}
