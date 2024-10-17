package RecapApi;

import baseUrl.ReqResBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DELETE_ApiTest extends ReqResBaseUrl {

 /*

         https://reqres.in/api/users/57 URL'sine bir DELETE isteği gönderin.
        Gelen yanıtın durum kodunun 204 olduğunu doğrulayın.

  */

    @Test
    public void test() {
        specReqres.pathParams("pp1","api","pp2","users","pp3","57");


        Response respnose=given().spec(specReqres).when().delete("/{pp1}/{pp2}/{pp3}");

        Assert.assertEquals(respnose.getStatusCode(),204, "StatusCode 204 değil");
    }
}
