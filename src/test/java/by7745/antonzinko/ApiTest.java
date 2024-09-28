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
        headers.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
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

    @Test
    public void testLogin() {
        String formParam = "prefix, 375";
        String LOGIN_URL = "https://7745.by/login";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
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

    @Test
    public void testIncorrectData() {
        String body = "prefix, 375";
        String LOGIN_URL = "https://7745.by/login";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                headers(headers).
                body(body).
                when().
                post(LOGIN_URL).
                then().
                log().all();
    }

    @Test
    public void testEmptyData() {
        String body1 = "prefix, 375";
        String LOGIN_URL1 = "https://7745.by/login";
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
        given().
                headers(headers1).
                body(body1).
                when().
                post(LOGIN_URL1).
                then().
                log().all();
    }

    @Test
    public void testEmptyLogin() {
        String body2 = "prefix, 375";
        String LOGIN_URL2 = "https://7745.by/login";
        Map<String, String> headers2 = new HashMap<>();
        headers2.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
        given().
                headers(headers2).
                body(body2).
                when().
                post(LOGIN_URL2).
                then().
                log().all();
    }

    @Test
    public void testEmptyPassword() {
        String body3 = "prefix, 375";
        String LOGIN_URL3 ="https://7745.by/login";
        Map<String, String> headers3 = new HashMap<>();
        headers3.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
        given().
                headers(headers3).
                body(body3).
                when().
                post(LOGIN_URL3).
                then().
                log().all();
    }
}
