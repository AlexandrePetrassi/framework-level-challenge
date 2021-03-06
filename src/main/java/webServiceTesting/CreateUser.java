package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

  private static final String USER_AND_JOB_JSON_TEMPLATE = "{\n" +
          "    \"name\": \"%s\",\n" +
          "    \"job\": \"%s\"\n" +
          "}";

  private String name;
  private String job;
  private String surname = "autoSurname";
  private final RequestSpecification requestSpecification;

  public CreateUser() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api")
        .basePath("/users");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFullName() {
    return name + " " + surname;
  }

  public String buildBody() {
    return String.format(USER_AND_JOB_JSON_TEMPLATE, name, job);
  }

  public String buildBodyWithSurname() {
    return String.format(USER_AND_JOB_JSON_TEMPLATE, getFullName(), job);
  }
}
