package put_Request;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void put01() {

        //1.set the url
        spec.pathParams("first","todos","second",198);

        //2. set the expected Data
        JsonPlaceHolderTestData expectredData =new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap = expectredData.expectedDataWithAllKeys(21,"Wash the dishes",false);

        //3. Set send the put Request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().put("/{first}/{second}");
        response.prettyPrint();

        //4.Do Assertion

        Map<String,Object> actualDataMap = response.as(HashMap.class);
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
    }
}
