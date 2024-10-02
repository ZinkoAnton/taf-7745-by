package by7745.antonzinko.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testFormData() {
        final String LOGIN_URL = "https://7745.by/login";
        Map<String, String> formParam = new HashMap<>();
        formParam.put("prefix", "375");
        formParam.put("login", "(00) 000-00-00");
        formParam.put("password", "123456");
        formParam.put("remember", "on");
        formParam.put("target", null);
        formParam.put("looking_page", "Nzc0NS5ieS8=");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParams(formParam).
                headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                when().
                post(LOGIN_URL).
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testLogin() {
        final String LOGIN_URL = "https://7745.by/login";
        given().
                when().
                post(LOGIN_URL).
                then().
                statusCode(302).
                log().all();
    }

    @Test
    public void testIncorrectData() {
        final String LOGIN_URL = "https://7745.by/login";
        Map<String, String> formParam = new HashMap<>();
        formParam.put("prefix", "375");
        formParam.put("login", "й");
        formParam.put("password", "");
        formParam.put("remember", "on");
        formParam.put("target", null);
        formParam.put("looking_page", "Nzc0NS5ieS8=");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParams(formParam).
                headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                when().
                post(LOGIN_URL).
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testEmptyData() {
        final String LOGIN_URL = "https://7745.by/login";
        Map<String, String> formParam = new HashMap<>();
        formParam.put("prefix", "");
        formParam.put("login", "");
        formParam.put("password", "");
        formParam.put("remember", "");
        formParam.put("target", null);
        formParam.put("looking_page", "");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParams(formParam).
                headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                when().
                post(LOGIN_URL).
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testEmptyLogin() {
        final String LOGIN_URL = "https://7745.by/login";
        Map<String, String> formParam = new HashMap<>();
        formParam.put("prefix", "375");
        formParam.put("login", "");
        formParam.put("password", "123456");
        formParam.put("remember", "on");
        formParam.put("target", null);
        formParam.put("looking_page", "Nzc0NS5ieS8=");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParams(formParam).
                headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                when().
                post(LOGIN_URL).
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testEmptyPassword() {
        final String LOGIN_URL ="https://7745.by/login";
        Map<String, String> formParam = new HashMap<>();
        formParam.put("prefix", "375");
        formParam.put("login", "(00) 000-00-00");
        formParam.put("password", "");
        formParam.put("remember", "on");
        formParam.put("target", null);
        formParam.put("looking_page", "Nzc0NS5ieS8=");
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParams(formParam).
                headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                when().
                post(LOGIN_URL).
                then().
                statusCode(200).
                log().all();
    }
}
