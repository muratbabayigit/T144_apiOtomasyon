package RecapApi;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P06_Put_ResponseBodyTest {
    public static void main(String[] args) {

    /*
        https://reqres.in/api/users/2 URL'ine
        aşağıdaki JSON body ile PUT request gönderildiğinde
            {
                "name": "Murat",
                "job": "Senior QA"
            }

            dönen Response’un:

            Status code’unun 200 olduğunu,
            Content type’ının application/json; charset=utf-8 olduğunu,
            Response Body’sini updatedAt hariç aşağıdaki expectedBody ile birebir eşleştiğini test ediniz.

            {
                "name": "Ahmet",
                "job": "Senior QA",
                "updatedAt": "2025-03-05T12:34:56.789Z"
            }
     */
        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";
        JSONObject reqBody=new JSONObject();
        reqBody.put("name","Murat");
        reqBody.put("job","Senior QA");

        // Beklenen response body
        JSONObject expectedBody=new JSONObject();
        expectedBody.put("name","Murat");
        expectedBody.put("job","Senior QA");
        expectedBody.put("updatedAt", "2025-03-05T12:34:56.789Z");

        // PUT Request
        Response response = given().contentType("application/json; charset=utf-8")
                .header("Content-Type", "application/json")
                .when().body(reqBody.toString())
                .put("/users/2");



        // Dönen actual response'u JSON string olarak al
        JsonPath resJP = response.jsonPath();


        // Assert ile expected ve actual response'u karşılaştır
        Assertions.assertEquals(expectedBody.get("name"),resJP.get("name"));
        Assertions.assertEquals(expectedBody.get("job"),resJP.get("job"));

    }
}
