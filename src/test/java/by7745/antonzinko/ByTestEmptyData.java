package by7745.antonzinko;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ByTestEmptyData {

    @Test
    public void testEmptyData() {
        RestAssured.
                given().
                header("Content-Type", "application/json").
                body("{\"login\":\"\",\"password\":\"\"}").
                when().
                post("https://7745.by/login").
                then().
                log().all();
    }
}
