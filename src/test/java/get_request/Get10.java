package get_request;

import base_Urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
        "meta": null,
    "data": {
        "id": 2986,
        "name": "Mrs. Agastya Nambeesan",
        "email": "nambeesan_agastya_mrs@littel-schultz.com",
        "gender": "female",
        "status": "inactive"
          }
        }
     */

    @Test
    public void get01() {
        //1. Set the Url
        spec.pathParams("first","users","second",2965);

        //Set the Expecteddata
        Map<String,String>dataKeyMap = new HashMap<>();
        dataKeyMap.put("name","Mr. Gita Menon");
        dataKeyMap.put("email","gita_menon_mr@bayer.com");
        dataKeyMap.put("gender","female");
        dataKeyMap.put("status","inactive");

        Map<String,Object>expectedData =new HashMap<>();
        expectedData.put("meta", null);
        expectedData.put("data", dataKeyMap);

        //3. Stept: Set the reques Get the response
       Response response= given().spec(spec).when().get("/{first}/{second}");

        Map<String,Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expectedData.get("meta"),actualDataMap.get("meta"));
        assertEquals(dataKeyMap.get("name"),((Map)actualDataMap.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"),((Map)actualDataMap.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"),((Map)actualDataMap.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"),((Map)actualDataMap.get("data")).get("status"));

        //Actual data kismi Object, Map<String,Object>, goruldugu uzere 2. kisim hep object. o yuzden bu map olmadigi
        // icin casting yapiyoruz.

    }

}
