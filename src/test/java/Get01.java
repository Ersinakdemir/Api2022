import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*; //buraya normalde given  geldi given methodunu import ettigimiz
// icin ama * yapinca bütün bütün methodlari import ediyor

public class Get01 {
    /*
         1-Postman manuel Api testi icin kullaniliyor.
         2-Otomation testi icin Rest-Assured Library kullaniyoruz.
         3-Otomation kodlarinin yazimi icin su adimlari izliyoruz:
            a- Gereksinimleri anlama
            b- Test Case'i yazma
                i- Test case yazimi icin 'Gherkin Language' kullaniyoruz
                    'Gherkin' bazi keywordlere sahip, bunlar
                    x- Given: ön kosul
                    y- When: Aksiyonlar --> Get, put, ...
                    z- Then: OutPut --> dönütler, Dönütler, response, ...
                    t- And: Coklu islemler

            c- Testing Kodun yazimi
                i- Set the URL
                ii- Set the expected data(POST-PUT-PATCH)
                iii- Type code to send request  // Yapacagimiz islemi seciyoruz
                iv - Do Asserttion
     */
    //Given
    //            https://restful-booker.herokuapp.com/booking/34
    //        When
    //            User sends a GET Request to the url
    //        Then
    //            HTTP Status Code should be 200
    //        And
    //            Content Type should be JSON
    //        And
    //            Status Line should be HTTP/1.1 200 OK

    @Test
    public void get01(){
        // i- Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/34";

        // ii- Set the expected data(POST-PUT-PATCH)

        // iii- Type code to send request
       Response response= given().when().get(url);  //Data almis olduk
        //response.prettyPrint();
        // iv - Do Asserttion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        System.out.println("Status Code: "+response.statusCode());

        System.out.println("Content Type: "+response.contentType());

        System.out.println("Statusline: "+response.statusLine());

        System.out.println("===================================================");

        System.out.println(response.headers());

        System.out.println("===================================================");


        System.out.println(response.getHeader("Date"));

        //Time  nasil yazilit
        System.out.println("Time: "+ response.getTime());






    }
}
