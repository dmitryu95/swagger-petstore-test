import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class PetTests extends Specification {
    @Test
    void PetFindStatusTest() {
        String STATUS = "status";
        String STATUS_VALUE = "sold";
        String PET_FIND_BY_STATUS = "/pet/findByStatus";

        Map<String, String> parameters = new HashMap<>();
        parameters.put(STATUS, STATUS_VALUE);

        given().queryParams(parameters)
        .when().get(PET_FIND_BY_STATUS)
        .then().log().all().statusCode(200);
    }


}
