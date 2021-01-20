import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StoreTests extends Specification {
    @Test
    void StoreOrderTest() {
        String STORE_ORDER = "/store/order";

        String ID = "id";
        int ID_VALUE = 9999999;
        String PET_ID = "petId";
        int PET_ID_VALUE = 0;
        String QUANTITY = "quantity";
        int QUANTITY_VALUE = 0;
        String SHIP_DATE = "shipDate";
        String SHIP_DATE_VALUE = "2021-01-20T12:29:36.807Z";
        String STATUS = "status";
        String STATUS_VALUE = "placed";
        String COMPLETE = "complete";
        boolean COMPLETE_VALUE = true;

        Map<String, Object> body = new HashMap<>();

        body.put(ID, ID_VALUE);
        body.put(PET_ID, PET_ID_VALUE);
        body.put(QUANTITY, QUANTITY_VALUE);
        body.put(SHIP_DATE, SHIP_DATE_VALUE);
        body.put(STATUS, STATUS_VALUE);
        body.put(COMPLETE, COMPLETE_VALUE);

        given().body(body)
        .when().post(STORE_ORDER)
        .then().log().all().statusCode(200);
    }
}
