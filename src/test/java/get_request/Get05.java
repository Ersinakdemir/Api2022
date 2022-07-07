package get_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Locale;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Adamz" and last name is "Dear"
     */
    @Test
    public void get01(){
        //1. Step: Set the Url
        //https://restful-booker.herokuapp.com/booking?firstname=Adamz&lastname=Dear
        spec.pathParam("first","booking")
                .queryParams("firstname","Sally","lastname", "Brown");
        //2. Stept: Set the expected data
        //3. Stept: Send the request ad get the response
        Response response =given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. Stept: Do Assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));
    }
}
