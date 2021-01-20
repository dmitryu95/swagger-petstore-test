import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserTests extends Specification{
    String USERNAME_CREATE = "/user/createWithList";
    String USER_USERNAME = "/user";

    String USERNAME_VALUE = "username1";
    String USERNAME_NEW_VALUE = "username2";

    String ID = "id";
    int ID_VALUE = 0;
    String USERNAME = "username";
    String FIRSTNAME = "firstName";
    String FIRSTNAME_VALUE = "string";
    String LASTNAME = "lastName";
    String LASTNAME_VALUE = "string";
    String EMAIL = "email";
    String EMAIL_VALUE = "string";
    String PASSVORD = "password";
    String PASSWORD_VALUE = "string";
    String PHONE = "phone";
    String PHONE_VALUE = "string";
    String USERSTATUS = "userStatus";
    int USERSTATUS_VALUE = 0;

    void UserNamePost() {
        Map<String, Object> body = new HashMap<>();

        body.put(ID, ID_VALUE);
        body.put(USERNAME, USERNAME_VALUE);
        body.put(FIRSTNAME, FIRSTNAME_VALUE);
        body.put(LASTNAME, LASTNAME_VALUE);
        body.put(EMAIL, EMAIL_VALUE);
        body.put(PASSVORD, PASSWORD_VALUE);
        body.put(PHONE, PHONE_VALUE);
        body.put(USERSTATUS, USERSTATUS_VALUE);

        given().body(body)
        .when().post(USERNAME_CREATE)
        .then().log().all().statusCode(200);
    }

    @Test
    void UserNamePutTest() {
        UserNamePost();

        Map<String, Object> body = new HashMap<>();

        body.put(ID, ID_VALUE);
        body.put(USERNAME, USERNAME_NEW_VALUE);
        body.put(FIRSTNAME, FIRSTNAME_VALUE);
        body.put(LASTNAME, LASTNAME_VALUE);
        body.put(EMAIL, EMAIL_VALUE);
        body.put(PASSVORD, PASSWORD_VALUE);
        body.put(PHONE, PHONE_VALUE);
        body.put(USERSTATUS, USERSTATUS_VALUE);

        given().body(body)
        .when().put(USER_USERNAME + "/" + USERNAME_VALUE)
        .then().log().all().statusCode(200);
    }

    @Test
    void UserDeleteTest() {
        given()
        .when().delete(USER_USERNAME + "/" + USERNAME_NEW_VALUE)
        .then().log().all().statusCode(200);
    }
}
