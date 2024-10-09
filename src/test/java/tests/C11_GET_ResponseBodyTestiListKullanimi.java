package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C11_GET_ResponseBodyTestiListKullanimi {
/*

    https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url’ine
    bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin Aplication.JSON,
    ve response body’sindeki
        eczane sayısıın sayisinin 4
        ve eczane’lerden birinin “DELİCE ECZANESİ”
        ve eczanele ilçelerinde icinde Merkez ,Delice ve Keskin degerinin oldugunu test edin.
 */
    @Test
    public void test01(){
        String url="https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale";

       //  Response response=given().when().header("authorization", "apikey 0nyKmlNCRNlQ4D9oV1iTLG:6ZcCt0k9g6d1wo4cDQr0cg")
    }


}
