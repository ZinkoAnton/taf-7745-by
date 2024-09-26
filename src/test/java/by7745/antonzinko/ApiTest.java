package by7745.antonzinko;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class ApiTest {

    @Test
    public void testFormData() {
        String formParam = "prefix, 375";
        String LOGIN_URL = "https://7745.by/login";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "multipart/form-data");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParam(formParam).
                headers(headers).
                when().
                post(LOGIN_URL).
                then().log().all();
    }
}
