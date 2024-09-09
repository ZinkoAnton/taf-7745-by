package by7745.antonzinko;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class ByTestStatusCodeErr {

    @Test
    public void test() {
        RestAssured.
                given().
                when().
                post("https://7745.by/login").
                then().
                statusCode(200);
    }
}
