package by7745.antonzinko;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ByTestEmptyLogin {

    @Test
    public void testEmptyLogin() {
        RestAssured.
                given().
                header("Content-Type", "application/json").
                body("{\"login\":\"\",\"password\":\"1\"}").
                when().
                post("https://7745.by/login").
                then().
                log().all();
    }
}
