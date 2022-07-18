package get_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class get09 extends HerOkuAppBaseUrl {
    /*
    Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
            {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
         }
     */

    @Test
    public void get01() {
        //1. Set the Url
        spec.pathParams("first","booking","second",91);

        //2. Set the Expected Data
        Map<String,String> bookinDatesMap = new HashMap<>();
        bookinDatesMap.put("checkin","2018-01-01");
        bookinDatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedData =new HashMap<>();
        expectedData.put("firstname","James");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookinDatesMap);
        expectedData.put("additionalneeds","Breakfast");

        System.out.println(expectedData);

        //3. Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String,Object>actualDataMap =response.as(HashMap.class);

        System.out.println(actualDataMap);

        //4. Do the Assertion
        assertEquals(expectedData.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(bookinDatesMap.get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(bookinDatesMap.get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualDataMap.get("additionalneeds"));

    }
}
