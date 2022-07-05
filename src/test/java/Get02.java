import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class Get02 {
/*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void test01() {
        //1.Stept: Set the Url
        String url = "https://restful-booker.herokuapp.com/booking/1";

        // 2. Stept Set the expected data(Post- Put- Patch)

        //3. Stept type code to send request
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //response badide bulunan spesifict bir veri nasil yazdirilir
        assertTrue(response.asString().contains("Not Found"));

        // Response body does not contain "TechProEd"
        assertFalse(response.asString().contains("TechProEd"));

        //assertEquals methodu iki dergerin esit olup olmadigini karsilastirir
        assertEquals("Cowboy",response.header("Server"));
    }
}
