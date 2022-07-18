package get_request;

import base_Urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
    /*
    Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Indra Ganaka", "Sarada Mehrotra", "Jagathi Chopra" are among the users
        And
            The female users are more than or equals to male users
     */

    @Test
    public void get01() {
        //Set the Url
        spec.pathParams("first","users");

        //2.Set the Expected Data

        //3. Stept Send the Request und get the response

        Response response =given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. Stept Do Assertion
        //1. Yol body() methodu ile
        response.then().assertThat().statusCode(200).body("meta.pagination.limit",equalTo(10),
                "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                "data.id",hasSize(10),
                "data.status",hasItem("active"),
                "data.name",hasItems());

        JsonPath json =response.jsonPath();
        List<String> genders=json.getList("data.gender");
        System.out.println(genders);

        int numOfFemales =0;
        for (String w:genders
             ) {
            if (w.equalsIgnoreCase("female")){
                numOfFemales++;
            }

        }
        System.out.println(numOfFemales);
        assertTrue(numOfFemales> genders.size()-numOfFemales);

        //2. Yol
        //Tüm bayan ve baylari ayri ayri Groovy ile cekelim
        List<String> femaleList =json.getList("data.findAll{it.gender=='female'}.gender");
        System.out.println(femaleList);
        List<String> maleList =json.getList("data.findAll{it.gender=='male'}.gender");
        System.out.println(maleList);

        assertTrue(femaleList.size()>maleList.size());
    }
}
