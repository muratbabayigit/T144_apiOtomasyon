package RecapApi;

import baseUrl.ReqResBaseUrl;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POST_ApiTest  {

/*

        https://reqres.in/api/users URL'sine
            header derğeri "Content-Type", "application/json" olan bir POST isteği gönderin.
            İstek için JSON formatında şu bilgileri içeren bir body kullanın: { "name": "morpheus", "job": "leader" }
            Gelen yanıtın durum kodunun 201 olduğunu doğrulayın.
            Yanıtın JSON body'sinde name alanının morpheus olduğunu kontrol edin.


 */

    @Test
    public void POST_ApiTest() {

        String url="https://reqres.in/api/users";

       // JSONObject reqBody = new JSONObject();
       // reqBody.put("name", "morpheus" );
       // reqBody.put("job", "leader");
//
      String reqBody="{\"name\" :\"morpheus\",\"job\":\"leader\"}";

        Response response=given().header("Content-Type", "application/json").when().body(reqBody).post(url);
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),201,"StatusCode isn't 201");
        Assert.assertEquals(response.jsonPath().getString("name"),"morpheus","Name isn't morpheus");


    }




}
