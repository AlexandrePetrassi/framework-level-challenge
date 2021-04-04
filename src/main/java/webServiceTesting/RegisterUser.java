package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RegisterUser {

    private static final String EMAIL_WITHOUT_PASSWORD_TEMPLATE = "{\n" +
            "    \"email\": \"%s\",\n" +
            "}";

    private String email;
    private final RequestSpecification requestSpecification;

    public RegisterUser() {
        this.requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath("/register");
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String buildBodyWithoutPassword() {
        return String.format(EMAIL_WITHOUT_PASSWORD_TEMPLATE, email);
    }
}
