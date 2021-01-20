import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class Specification {
    static String BASE_URL = "https://petstore.swagger.io/v2";
    static {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON).build();
    }
}
