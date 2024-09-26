package by7745.antonzinko;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    public void testFormData() {
        given().
                formParam("prefix", "375").
                header("Content-Type", "multipart/form-data").
                when().
                post("https://7745.by/login").
                then().log().all();
    }

    @Test
    public void testIncorrectData() {
        String body = "{\"login\":\"\",\"1\"password\":\"\"}";
        String LOGIN_URL = "https://7745.by/login";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        given().
                headers(headers).
                body(body).
                when().
                post(LOGIN_URL).
                then().
                log().all();
    }

    @Test
    public void testEmptyData() {
        String body1 = "{\"login\":\"\",\"password\":\"\"}";
        String LOGIN_URL1 = "https://7745.by/login";
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
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
        String body2 = "{\"login\":\"\",\"password\":\"1\"}";
        String LOGIN_URL2 = "https://7745.by/login";
        Map<String, String> headers2 = new HashMap<>();
        headers2.put("Content-Type", "application/json");
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
        String body3 = "{\"login\":\"(1\",\"password\":\"\"}";
        String LOGIN_URL3 ="https://7745.by/login";
        Map<String, String> headers3 = new HashMap<>();
        headers3.put("Content-Type", "application/json");
        given().
                headers(headers3).
                body(body3).
                when().
                post(LOGIN_URL3).
                then().
                log().all();
    }

    @Test
    public void testLogin() {
        String body4 = "{\"login\":\"(1\",\"password\":\"1\"}";
        String LOGIN_URL4 = "https://7745.by/login";
        Map<String, String> headers4 = new HashMap<>();
        headers4.put("Content-Type", "application/json");
        given().
                headers(headers4).
                body(body4).
                when().
                post(LOGIN_URL4).
                then().
                log().all();
    }
}
