package RecapApi;

import baseUrl.ReqResBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P01_GET_Request extends ReqResBaseUrl {

 /*

        https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.
            Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
            Yanıtın JSON body'sinde yer alan data.id değerinin 2 olduğunu doğrulayın.
            Yanıt süresinin 2 saniyeden kısa olduğunu kontrol edin.

  */

    @Test
    public void testGET(){

        specReqres.pathParams("pp1","api","pp2","users","pp3","2");

        Response response= given().spec(specReqres).when().get("/{pp1}/{pp2}/{pp3}");

    Assert.assertEquals(response.getStatusCode(),200);

        int dataId=response.jsonPath().getInt("data.id");
        Assert.assertEquals(dataId,2, "User id is not correct");

        Assert.assertTrue(response.getTime()<2000,"Response is very slow!");
    }
}
