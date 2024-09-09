package by7745.antonzinko;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ByTestIncorrectData {

    @Test
    public void testIncorrectData() {
        RestAssured.
                given().
                header("Content-Type", "application/json").
                body("{\"login\":\"\",\"1\"password\":\"\"}").
                when().
                post("https://7745.by/login").
                then().
                log().all();
    }
}
