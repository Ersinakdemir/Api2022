package get_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkuAppBaseUrl {
    /*
    Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
        }
     */

    @Test
    public void get01() {
        //1. Stept: Set the Url
        spec.pathParams("first", "booking", "second",25);
        //2. Stept: Set teh expected Data
        //3. Stept: Set the,  request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do the Asserttion
        //1. Yol
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Sally"),
                        "lastname",equalTo("Brown"),
                        "totalprice",equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2013-02-23"),
                        "bookingdates.checkout",equalTo("2014-10-23"));

        //2.Yol: Yol JsonPath Class kullanilir
        JsonPath json = response.jsonPath();
        assertEquals("Sally",json.getString("firstname"));
        assertEquals("Brown", json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2013-02-23",json.getString("bookingdates.checkin"));
        assertEquals("2014-10-23",json.getString("bookingdates.checkout"));

        //3. Yol: Soft Assertion
        //Soft Assertion icin 3 adi m izlenir

        //1. Softassert objesi olusturulur
        SoftAssert softAssert = new SoftAssert();

        //2. obj araciligla assertion yapilir

        softAssert.assertEquals(json.getString("firstname"),"Sally","isimler uyusmadi");
        softAssert.assertEquals(json.getString("lastname"),"Brown");
        softAssert.assertAll();
    }
}
