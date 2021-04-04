package webServiceTesting.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webServiceTesting.RegisterUser;

public class RegisterUserTest {

    RegisterUser registerUser = new RegisterUser();
    String jsonWithoutPassword = "{\n" +
            "    \"email\": \"test@email.com\",\n" +
            "}";

    @Before
    public void setup() {
        registerUser.setEmail("test@email.com");
    }

    @Test
    public void buildBodyWithoutPassword_validUserAndJob_shouldReturnJsonWithUserAndJob() {
        Assert.assertEquals(jsonWithoutPassword, registerUser.buildBodyWithoutPassword());
    }

}