package by7745.antonzinko;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ByTestLogin {

    @Test
    public void testLogin() {
                given().
                        header("Content-Type", "application/json").
                        body("{\"login\":\"(1\",\"password\":\"1\"}").
                        when().
                        post("https://7745.by").
                        then().
                        log().all();
    }
}
