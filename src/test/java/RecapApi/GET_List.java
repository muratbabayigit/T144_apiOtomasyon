package RecapApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GET_List {


/*

        https://reqres.in/api/users?page=2 URL'sine bir GET isteği gönderin.
        Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
        Liste içerisindeki kullanıcı sayısının en az 1 olduğunu doğrulayın.
        İlk kullanıcının email adresinin boş olmadığını kontrol edin.

 */

    @Test
    public void getList(){
        String url="https://reqres.in/api/users?page=2";

        Response response= RestAssured.get(url);
        // given() ; Header vb özellikler eklenlecekse kullanılır
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);

        // Jsonpath resJP=response.jsonPath()
        int userCount=response.jsonPath().getList("data").size();
       // data listesinin içindeki eleman sayısını yazdırdık

        Assert.assertTrue(userCount>0,"User List Empty");

        String firstEmail=response.jsonPath().getString("data[0].email");
        Assert.assertNotNull(firstEmail,"First person's mail is null");
        Assert.assertFalse(firstEmail.isEmpty(),"First person's mail is empty");



    }
}
