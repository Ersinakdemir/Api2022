import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class calismalar {

    // https://restful-booker.herokuapp.com/booking/44 url'ine
    // bir GET request gonderdigimizde donen Response'un,
    //        status code'unun 200,
    //        ve content type'inin "application/json"; charset=utf-8,
    //        ve Server isimli Header'in degerinin Cowboy,
    //        ve status Line'in HTTP/1.1 200 OK
    //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.

    @Test
    public void name() {
        String url = "https://restful-booker.herokuapp.com/booking/18";
        Response response = given().when().get(url);
            response.then().assertThat().statusCode(200);
            response.then().assertThat().contentType("application/json").header("Server","Cowboy")
                    .statusLine("HTTP/1.1 200 OK");
           Assert.assertTrue( response.getTime()<5000);
        System.out.println(response.getHeader("Server"));
    }
}
