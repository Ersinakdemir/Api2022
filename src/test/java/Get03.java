import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends BaseUrls{
 /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */

    @Test
    public void get01() {
        //1. Set the Url
        //String url = "https://jsonplaceholder.typicode.com/todos/23";
        spec.pathParams("first","todos","second",23);

        //2. Step:
        //3: Stept: send the request and get the response
       Response response = given().spec(spec).when().get("/{first}/{second}");    //Burdaki spec() in Base clasindaki spec ile alakasi
                                                                                    // yok burda ki bir method digeri bir variable
        //4. Stept: Do Assertion
        //1.Yol:
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId", equalTo(2));
        // 2. Yol:
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId", equalTo(2));


    }
}
