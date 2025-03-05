package RecapApi;

import baseUrl.ReqResBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.ReqResPOJO;

public class P05_PUT_POJOApiTest extends ReqResBaseUrl {

/*

    https://reqres.in/api/users/2 URL'sine header değeri "Content-Type","application/json" olan bir PUT isteği gönderin.
        Kullanıcıyı şu şekilde güncelleyin: { "name": "John Doe", "job": "Manager" }.
        Yanıtın durum kodunun 200 olduğunu doğrulayın ve name alanının John Doe olduğunu doğrulayın.

 */

    @Test
    public void testPutPOJO() {
        specReqres.pathParams("pp1","api","pp2","users","pp3","2");

        ReqResPOJO user=new ReqResPOJO("John Doe","Manager");


        Response response= RestAssured
                .given()
                .spec(specReqres)
                .header("Content-Type","application/json")
                .body(user)
                .put("/{pp1}/{pp2}/{pp3}");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        //Assert.assertEquals(response.jsonPath().get("name"),"John Doe","İsim John Doe değil");


    }
}
