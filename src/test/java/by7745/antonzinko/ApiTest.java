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
    public void testLogin() {
        final String LOGIN_URL = "https://7745.by/login";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                headers(headers).
                when().
                post(LOGIN_URL).
                then().
                log().all();
    }

    @Test
    public void testIncorrectData() {
        String formParam = "prefix: ;2 ";
        final String LOGIN_URL = "https://7745.by/login";
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
                then().
                log().all();
    }

    @Test
    public void testEmptyData() {
        String formParam = "prefix: " +
                "login: " +
                "password: " +
                "remember: ";
        final String LOGIN_URL = "https://7745.by/login";
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
                then().
                log().all();
    }

    @Test
    public void testEmptyLogin() {
        String formParam = "prefix: 375; login: ; password: Я; remember: on";
        final String LOGIN_URL = "https://7745.by/login";
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
                then().
                log().all();
    }

    @Test
    public void testEmptyPassword() {
        String formParam = "prefix: 375; login: (9; password: ; remember: on";
        final String LOGIN_URL ="https://7745.by/login";
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
                then().
                log().all();
    }
}
