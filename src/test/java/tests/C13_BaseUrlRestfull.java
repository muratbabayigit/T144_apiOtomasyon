package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C13_BaseUrlRestfull extends RestfulBaseUrl {

 /*

       https://restful-booker.herokuapp.com/booking endpointine
       bir GET request gonderdigimizde donen response’un
       status code’unun 200 oldugunu ve
       Response’ta 12 booking oldugunu test edin

  */

    @Test
    public void test01(){
        specRestfull.pathParam("ilk","booking");
        Response response=given().spec(specRestfull).when().get("/{ilk}");
        response.then().assertThat().statusCode(200);
        //.body("booking", Matchers.hasSize(12));

    }


    //ÖDEV SORUSU:
    /*
            https://restful-booker.herokuapp.com/booking endpointine
            asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un
            status code’unun 200 oldugunu ve “firstname” degerinin “Murat” oldugunu test edin
{
     "firstname" : “Murat”,
     “lastname” : “Yiğit”,
     “totalprice” : 500,
     “depositpaid” : false,
     “bookingdates” : {
              “checkin” : “2021-06-01”,
              “checkout” : “2021-06-10”
                       },
     “additionalneeds” : “wi-fi”
  }
     */

    // Soruda eğer method türü belirtilmemişse
    // Yeni bir kayıt: POST
    // Güncelleme : PUT(Full) - PATCH (Parçalı)
    // Görüntüleme : GET
    // Silme : DELETE

    @Test
    public void test02(){
        specRestfull.pathParam("ilk","booking");
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wi-fi,Breakfast");

        Response response=given().contentType(ContentType.JSON)
                                 .when().spec(specRestfull).body(reqBody.toString()).post("/{ilk}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("booking.firstname",Matchers.equalTo("Murat"));



    }

}
