package patch_Request;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class patch01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */

    @Test
    public void patch01() {
        //1. Set the Url
        spec.pathParams("1","todos","2",198);

        //2. Set the request body
        JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
        Map<String,Object> requestBodyMap  = requestBody.expectedDataWithMisingKeys(5,null,null);

        //3. Send the Patch request get the respose

        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{1}/{2}");
        response.prettyPrint();
    }
}
